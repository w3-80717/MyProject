import React from 'react';
import {  Container } from '@mui/material';
import Navbar from '../components/Navbar';
import CustomCarousel from '../components/CustomCarousel';
import FourCardGridCategory from '../components/FourCardGridCategory';
import FourCardGridSubCategory from '../components/FourCardGridSubCategory';


const Home = () => {
  return (
    <div>
      <Navbar />
      <Container>
        <CustomCarousel />
        <FourCardGridCategory />
        <FourCardGridSubCategory />
      </Container>
    </div>
  );
};

export default Home;
