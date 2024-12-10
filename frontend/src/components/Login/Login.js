import React, { useEffect, useState } from "react";
import {
  Box,
  Button,
  Card,
  FormControl,
  InputLabel,
  OutlinedInput,
  Typography,
  Grid,
} from "@mui/material";
import "./Login.css";
import Aos from "aos";
import axiosInstance from "../../axiosInstance"; // Đảm bảo axiosInstance được import
import { useNavigate } from "react-router-dom";
import Swal from 'sweetalert2';

export default function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState(""); // New state for error messages
  const navigate = useNavigate();

  useEffect(() => {
    Aos.init();
    window.scrollTo(0, 0);
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setErrorMessage("");  // Reset error message before submitting

    try {
      const response = await axiosInstance.post('/api/users/login', {
        username: username,
        password: password
      });

      console.log(response.data);  // Kiểm tra dữ liệu trả về từ API

      // Nếu đăng nhập thành công, hiển thị thông báo và chuyển hướng
      Swal.fire({
        title: 'Login Successful!',
        text: 'You will be redirected shortly.',
        icon: 'success',
        timer: 2000,
        showConfirmButton: false,
      });

      setTimeout(() => {
        navigate("/");  // Redirect to home page after 2 seconds
      }, 2000);

    } catch (error) {
      console.error('Có lỗi xảy ra:', error.response ? error.response.data : error.message);
      setErrorMessage('Something went wrong');  // Hiển thị thông báo lỗi cho người dùng
    }
  };

  return (
      <div className="bg-login">
        <Grid container spacing={2}>
          <Grid item xs={12} sm={6} className="left-box" data-aos="fade-right">
            <h1 className="title-welcome">Chào Mừng Học Viên Mới</h1>
            <div className="logo-web"></div>
          </Grid>
          <Grid item xs={12} sm={6} className="login-box" data-aos="fade-left">
            <div className="overlay"></div>
            <div className="content">
              <Box sx={{ padding: "16px", maxWidth: 400, margin: "auto" }}>
                <Card elevation={1}>
                  <Box sx={{ padding: "16px" }}>
                    <Box sx={{ textAlign: "center", marginBottom: "24px" }}>
                      <Typography variant="h4" component="h4" gutterBottom>
                        Sign in
                      </Typography>
                      <Typography variant="body1" color="text.secondary">
                        Welcome back
                      </Typography>
                      {errorMessage && <p className="text-danger">{errorMessage}</p>} {/* Display error message */}
                    </Box>
                    <form onSubmit={handleSubmit}>
                      <FormControl fullWidth variant="outlined" margin="normal">
                        <InputLabel>Username</InputLabel>
                        <OutlinedInput
                            type="text"
                            label="Username"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                            required
                        />
                      </FormControl>
                      <FormControl fullWidth variant="outlined" margin="normal">
                        <InputLabel>Password</InputLabel>
                        <OutlinedInput
                            type="password"
                            label="Password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                        />
                      </FormControl>
                      <Button
                          variant="contained"
                          color="primary"
                          fullWidth
                          type="submit"
                          sx={{ mt: 2, mb: 2 }}
                      >
                        Login
                      </Button>
                    </form>
                  </Box>
                </Card>
              </Box>
            </div>
          </Grid>
        </Grid>
      </div>
  );
}
