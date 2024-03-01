import React from 'react';
import { Container, Typography, Card, CardContent, Button } from '@mui/material';
import necklaceImg from '../images/necklace.jpeg';
import ringImg from '../images/ring.jpeg';
import earringImg from '../images/earring.jpeg';
import noseRingImg from '../images/nosering.jpeg';

const subCategories = ['Necklace', 'Ring', 'Earring', 'NoseRing'];

const subcategoryImages = {
  Necklace: necklaceImg,
  Ring: ringImg,
  Earring: earringImg,
  NoseRing: noseRingImg
};

const SubCategory = () => {
  const handleSubCategoryClick = (subCategory) => {
    
    console.log(`Selected sub-category: ${subCategory}`);
  };

  return (
    <Container>
      <Typography variant="h4" align="center" style={{ marginTop: 20, color: "#832729", fontWeight: "bold" }}>
        Shop by Sub Category
      </Typography>
      <div style={{ display: 'flex', justifyContent: 'space-around', marginTop: 20, marginBottom: 20 }}>
        {subCategories.map((subCategory, index) => (
          <Card 
            key={index} 
            sx={{ 
              width: 200,
              color: '#832729', 
              }}>
            <CardContent
              sx={{ 
                backgroundImage: `url(${subcategoryImages[subCategory]})`,
                backgroundSize: 'cover',
                backgroundPosition: 'center',
              }}
            >
              <Typography variant="h5" sx={{fontWeight: "bold"}}>{subCategory}</Typography>
              <Button onClick={() => handleSubCategoryClick(subCategory)} variant="text" color="primary" sx={{ marginTop: 2, color: "#832729", fontWeight: "bold" }}>
                Explore
              </Button>
            </CardContent>
          </Card>
        ))}
      </div>
    </Container>
  );
};

export default SubCategory;
