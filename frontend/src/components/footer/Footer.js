import React from "react";
import { Container, Row, Col } from "reactstrap";
import logo from "../../resources/logo.png";
import { Box, Typography, Link, Grid } from "@mui/material";
import { NavLink } from "react-router-dom";
import "./footer.css";

export default function Footer() {
  return (
    <div
      className="footer"
      style={{ backgroundColor: "#C5A689", padding: "60px 0 12px 0" }} // Match background color
    >
      <Container>
        <Row>
          {/* Logo and company description */}
          <Col xs={12} sm={6} md={6} style={{ paddingLeft: "60px", paddingRight: "60px" }}>
            <div>
              <img
                src={logo}
                alt="Logo"
                className="footer-logo"
                style={{ width: "150px" }}
              />
              <p style={{ marginTop: "1rem", width: "" }}>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do
                eiusmod tempor incididunt ut labore et dolore magna aliqua.
              </p>
            </div>
          </Col>

          {/* Useful Links */}
          <Col xs={12} sm={6} md={3}>
            <h6 style={{ marginBottom: "20px", color: "#603E31" }}>
              Liên Kết Hữu Ích
            </h6>
            <p>
              <i
                className="fa-solid fa-house"
                style={{ marginRight: "0.5rem" }}
              ></i>
              <NavLink to="/" className="footer-link" color="#603E31">
                Trang Chủ
              </NavLink>
            </p>
            <p>
              <i
                className="fa-solid fa-bag-shopping"
                style={{ marginRight: "0.5rem" }}
              ></i>
              <NavLink to="/products" className="footer-link" color="#603E31">
                Lớp học
              </NavLink>
            </p>
            <p>
              <i
                className="fa-solid fa-cart-shopping"
                style={{ marginRight: "0.5rem" }}
              ></i>
              <NavLink to="/cart" className="footer-link" color="#603E31">
              Đăng nhập/Đăng ký
              </NavLink>
            </p>
            <p>
              <i
                className="fa-solid fa-envelope"
                style={{ marginRight: "0.5rem" }}
              ></i>
              <NavLink to="/contact" className="footer-link" color="#603E31">
                Liên Hệ
              </NavLink>
            </p>
          </Col>

          {/* About Us */}
          <Col xs={12} sm={6} md={3}>
            <h6 style={{ marginBottom: "20px", color: "#603E31" }}>About Us</h6>
            <p>
              <i
                className="fa-solid fa-circle-info"
                style={{ marginRight: "0.5rem" }}
              ></i>
              <NavLink to="/aboutus" className="footer-link" color="#603E31">
                Thông Tin Thêm
              </NavLink>
            </p>
            <p>
              <i
                className="fa-solid fa-circle-info"
                style={{ marginRight: "0.5rem" }}
              ></i>
              <NavLink to="/reviews" className="footer-link" color="#603E31">
                Đánh Gía
              </NavLink>
            </p>
            <p>
              {/* <i
                className="fa-solid fa-circle-info"
                style={{ marginRight: "0.5rem" }}
              ></i> */}
              {/* <NavLink to="/terms" className="footer-link" color="#603E31">
                Terms of Service
              </NavLink> */}
            </p>
          </Col>
        </Row>

        {/* Divider */}
        <hr style={{ borderColor: "#555", margin: "2rem 0" }} />

        {/* Contact and Social Media */}
        <Container style={{ maxWidth: "1100px", margin: "0 auto" }}>
        <Row className="justify-content-between">
          <Col>
            <Box sx={{ padding: "2rem", color: "#fff" }}>
              <Grid container spacing={2}>
                <Grid item xs={12}>
                  <Typography variant="h6" color="#603E31">
                    Thông Tin Liên Hệ
                  </Typography>
                </Grid>
                <Grid item xs={12} sm={12}>
                  <Typography variant="body1" color="#603E31">
                    Địa Chỉ: 227 Nguyễn Văn Cừ, Phương 1, Quận 5, Hồ Chí Minh
                  </Typography>
                  <Typography variant="body1" color="#603E31">
                    Thứ Hai - Thứ Sáu: 9am - 5pm
                  </Typography>
                  <Typography variant="body1">
                    <NavLink
                      to="/contact"
                      className="footer-link"
                      style={{ textDecoration: "none", color: "#603E31" }} // Remove underline
                    >
                      Gửi Tin Nhắn
                    </NavLink>
                  </Typography>
                </Grid>
                {/* <Grid item xs={12} sm={3}> */}
                  {/* <Typography variant="body1">
                    <NavLink
                      to="/contact"
                      className="footer-link"
                      style={{ textDecoration: "none", color: "#603E31" }} // Remove underline
                    >
                      Gửi Tin Nhắn
                    </NavLink>
                  </Typography> */}
                {/* </Grid> */}
              </Grid>
            </Box>
          </Col>
          <Col className="text-right">
            <div className="footer-icons">
              <a href="#" className="footer-icon">
                <i
                  className="fa-brands fa-facebook"
                  style={{ fontSize: "30px" }}
                ></i>
              </a>
              <a href="#" className="footer-icon instagram">
                <i
                  className="fa-brands fa-instagram"
                  style={{ fontSize: "30px" }}
                ></i>
              </a>
              <a href="#" className="footer-icon youtube">
                <i
                  className="fa-brands fa-youtube"
                  style={{ fontSize: "30px" }}
                ></i>
              </a>
            </div>
          </Col>
        </Row>
        </Container>
        {/* Footer bottom text */}
        <div
          style={{
            textAlign: "center",
            marginTop: "2rem",
            paddingBottom: "1rem",
            color: "#bbb",
          }}
        >
          <p>© 2024 . All rights reserved. - Furniture Corner</p>
        </div>
      </Container>
    </div>
  );
}
