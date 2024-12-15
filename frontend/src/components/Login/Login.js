import React, { useEffect, useState } from "react";
import { useDispatch } from "react-redux";  // Thêm import useDispatch
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
import axiosInstance from "../../utils/axiosInstance";
import { useNavigate } from "react-router-dom";
import Swal from 'sweetalert2';
import { login } from '../../redux/userSlice';  // Thêm import action login nếu cần

export default function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const navigate = useNavigate();
  const dispatch = useDispatch();  // Khởi tạo dispatch

  useEffect(() => {
    Aos.init();
    window.scrollTo(0, 0);
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setErrorMessage("");

    try {
      const response = await axiosInstance.post('/api/users/login', {
        username: username,
        password: password
      });

      console.log(response.data);

      // Lưu token vào localStorage và thông tin người dùng
      localStorage.setItem('accessToken', response.data.token);
      localStorage.setItem('role', response.data.role);
      localStorage.setItem('userInfo', JSON.stringify(response.data));

      // Thực hiện dispatch action login vào Redux
      dispatch(login({ username: response.data.username, role: response.data.role }));

      Swal.fire({
        title: 'Login Successful!',
        text: 'You will be redirected shortly.',
        icon: 'success',
        timer: 2000,
        showConfirmButton: false,
      });

      setTimeout(() => {
        navigate("/");
      }, 2000);

    } catch (error) {
      console.error('Có lỗi xảy ra:', error.response ? error.response.data : error.message);
      setErrorMessage('Có lỗi xảy ra');
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
                      {errorMessage && <p className="text-danger">{errorMessage}</p>}
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
