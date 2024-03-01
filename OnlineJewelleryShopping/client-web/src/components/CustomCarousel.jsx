import React from 'react';
import { Card, CardContent } from '@mui/material';
import Carousel from 'react-material-ui-carousel';
import image1 from '../images/img1.jpeg';
import image2 from '../images/img2.jpeg';
import image3 from '../images/img3.jpeg';
import image4 from '../images/img4.jpeg';

const images = [image1, image2, image3, image4];

const CustomCarousel = () => {
  return (
    <div>
      
      <Carousel
        autoPlay={true}
        interval={5000}
        animation="fade"
        indicators={false}
        navButtonsAlwaysVisible
        navButtonsProps={{ 
          style: {
            backgroundColor: '#832729',
            borderRadius: '50%',
            width: 36,
            height: 36,
          }
        }}
      >
        {images.map((image, index) => (
          <Card key={index} sx={{height: "500px", width: "100%", backgroundColor: "#ffe6ff"}} >
            <CardContent>
              <img src={image} alt={`Slide ${index + 1}`} style={{ width: '100%', height: '465px', objectFit: 'cover' }} />
            </CardContent>
          </Card>
        ))}
      </Carousel>
    
    </div>
  );
};

export default CustomCarousel;
