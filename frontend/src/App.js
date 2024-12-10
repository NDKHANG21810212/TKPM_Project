import React from "react";
import { HashRouter, Routes, Route } from "react-router-dom";
import CartPage from "./pages/CartPage/CartPage";
import ContactPage from "./pages/ContactPage/ContactPage";
import Home from "./pages/Home/Home";
import AboutUsPage from "./pages/AboutUsPages/AboutUsPage";
import DetailPage from "./pages/DetailPage/DetailPage";
import ProductPage from "./pages/productpage/ProductPage";
import LoginPage from "./pages/LoginPage/LoginPage";
import SettingPage from "./pages/SettingPage/SettingPage";
import UserList from "./components/Login/UserList";
import ProtectedRoute from './components/ProtectedRoute';
import Blogpage from "./pages/BlogPage/Blogpage";
import QuizPage from "./pages/QuizPage/QuizPage";

export default function App() {
  return (
    <div>
      <HashRouter>
        <Routes>
          {/* <Route path="/student" element={<ProtectedRoute element={StudentPage} role="admin" />} />*/}
          <Route path="/" element={<Home />} />

          {/* <Route path="/cart" element={<CartPage />} /> */}
          
          <Route path="/cart" element={<ProtectedRoute element={CartPage} allowedRoles={['USER']} />} />

          <Route path="/contact" element={<ContactPage />} />
          <Route path="/aboutus" element={<AboutUsPage />} />
          <Route path="/products" element={<ProductPage />} />
          <Route path="/detail/:id" element={<DetailPage />} />
          {/* <Route path="/detail/:id" element={<DetailPage />} /> */}
          <Route path="/products/detail/:id" element={<DetailPage />} />
          <Route path="/login" element={<LoginPage />} />
          <Route path="/listuser" element={<UserList />} />
          <Route path="/user" element={<SettingPage />} />
          <Route path="/reviews" element={<Home/>} />
          <Route path="/blog" element={<Blogpage />} />
          <Route path="/quiz" element={<QuizPage />} />
        </Routes>
      </HashRouter>
    </div>
  );
}
