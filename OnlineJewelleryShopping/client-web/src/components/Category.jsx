import React from 'react';
import { Container, Typography, Card, CardContent, Button } from '@mui/material';
import goldImg from '../images/gold.jpg';
import silverImg from '../images/silver.jpg'
import diamondImg from '../images/diamond.png'
import platinumImg from '../images/platinum.jpg'

const categories = ['Gold', 'Silver', 'Diamond', 'Platinum'];

const categoryImages = {
  Gold: goldImg,
  Silver: silverImg,
  Diamond: diamondImg,
  Platinum: platinumImg
};

const Category = () => {
  const handleCategoryClick = (category) => {
    console.log(`Selected category: ${category}`);
  };

  return (
    <Container>
      <Typography variant="h4" align="center" style={{ marginTop: 20, color: "#832729", fontWeight: "bold" }}>
        Shop by Category
      </Typography>
      <div style={{ display: 'flex', justifyContent: 'space-around', marginTop: 20, marginBottom: 20 }}>
        {categories.map((category, index) => (
          <>
          <Card 
            key={index} 
            sx={{ 
              width: 200,
              backgroundImage: `url(${categoryImages[category]})`,
              backgroundSize: 'cover',
              backgroundPosition: 'center',
              color: '#832729',
              }}>
            <CardContent>
              <Typography variant="h5" sx={{fontWeight: "bold"}} >{category}</Typography>
              <Button onClick={() => handleCategoryClick(category)} variant="text" color="primary" sx={{ marginTop: 2, color: "#832729", fontWeight: "bold" }}>
                Explore
              </Button>
            </CardContent>
          </Card>
          
          </>
        ))}
      </div>
    </Container>
  );
};

export default Category;
