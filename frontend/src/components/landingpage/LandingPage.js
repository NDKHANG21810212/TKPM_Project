import React, { useEffect } from "react";
import "./landingpage.css";
import img1 from "../assets/product1.png";
import img2 from "../assets/product2.png";
import img3 from "../assets/product3.png";

import { useDispatch, useSelector } from "react-redux";
import { Row, Container } from "reactstrap";
import { getList } from "../../redux/shopSlice";
import Features from "../feature/Features";
import Review from "../Review/Review";
import Aos from "aos";
import "aos/dist/aos.css";


export default function LandingPage() {
  const dispatch = useDispatch();
  const { products } = useSelector((state) => state.shop);
  const images = [
    {
      src: img1,
    },
    {
      src: img2,
    },
    {
      src: img3,
    },
  ];

  useEffect(() => {
    dispatch(getList());
    window.scrollTo(0, 0);
    Aos.init();
  }, [dispatch]);

  const sliderSettings = {
    dots: false,
    infinite: true,
    slidesToShow: 1,
    slidesToScroll: 1,
    autoplay: true,
    speed: 1000,
    autoplaySpeed: 3000,
    pauseOnHover: true,
  };

  return (
    <div className="lander">
      <Container style={{ overflow: "hidden"}} fluid className="holder">
        <div className="first">
          <div
            className="backgroundLanding"
            style={{
              width: "100%",
              height: "100%",
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
              justifyContent: "center",
              color: "white",
              textAlign: "center",
              padding: 16,
            }}
          >
            <Container
              className="image_container"
              data-aos="fade-down"
              data-aos-duration="1500"
            >
              {/* <Slider {...sliderSettings}>
                {images.map((img, index) => (
                  <div key={index}>
                    <img
                      src={img.src}
                      className="landing_carousel"
                      alt="test"
                      style={{
                        maxWidth: "545px",
                        width: "100%",
                        height: "auto",
                        objectFit: "contain",
                        margin: "0 auto",
                      }}
                    />
                  </div>
                ))}
              </Slider> */}
            </Container>
            <div className="">
              <p
                className="Title3"
                data-aos="fade-right"
                data-aos-duration="1500"
              >
                {/* Furniture Corner */}
              </p>

              <p
                className="Title3"
                data-aos="fade-right"
                data-aos-duration="1500"
              >
                {" "}
                {/* Modern & Exclusive Furniture */}
              </p>
              {/* <button>
                <span class="button_top">
                  {" "}
                  <Link
                    className="appbar"
                    to="/products"
                    style={{ color: "inherit", textDecoration: "none" }}
                    data-aos="zoom-out"
                    data-aos-duration="1500"
                  >
                    Tham gia lớp học
                  </Link>
                </span>
              </button> */}
              <div style={{ width: "20px" }}></div>
              {/* <p
                className="Title3"
                data-aos="fade-left"
                data-aos-duration="1500"
              >
                <span className="innerTitle3"> Trend</span>
              </p> */}
            </div>
            <p
              className="text-light my-1"
              data-aos="zoom-out"
              data-aos-duration="1500"
            ></p>
            {/* <Link
              className="appbar"
              to="/products"
              style={{ color: "inherit", textDecoration: "none" }}
              data-aos="zoom-out"
              data-aos-duration="1500"
            >
            </Link> */}
          </div>
        </div>

        <Container>
          <Row className="py-5" style={{ overflow: "hidden" }}>
            {/* <BestSeller products={products} /> */}
          </Row>
        </Container>

        <Features />

        {/* <div style={{ padding: "3rem 0" }}>
          <Container style={{ overflow: "hidden"}}>
            <div className="d-flex">
              <p
                className="Title"
                data-aos="fade-right"
                data-aos-duration="1500"
              >
                All
              </p>
              <div style={{ width: "20px" }}></div>
              <p
                className="Title"
                data-aos="fade-left"
                data-aos-duration="1500"
              >
                <span className="innerTitle"> Items</span>
              </p>
            </div>
            <CarouselMain products={products} />
          </Container>
        </div> */}
        <Review />
      </Container>
    </div>
  );
}
