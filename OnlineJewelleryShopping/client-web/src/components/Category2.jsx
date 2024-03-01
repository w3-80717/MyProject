import React from 'react';
import { Container, Typography } from '@mui/material';
import CategoryCard from './CategoryCard';
import goldImg from '../images/gold.jpg';
import silverImg from '../images/silver.jpg';
import diamondImg from '../images/diamond.png';
import platinumImg from '../images/platinum.jpg';

const categories = ['Gold', 'Silver', 'Diamond', 'Platinum'];

const categoryImages = {
  Gold: goldImg,
  Silver: silverImg,
  Diamond: diamondImg,
  Platinum: platinumImg
};

const Category2 = () => {
  const handleCategoryClick = (category) => {
    console.log(`Selected category: ${category}`);
  };

  return (
    <Container>
      <Typography variant="h4" align="center" style={{ marginTop: 20, color: "#832729", fontWeight: "bold" }}>
        Shop by Category
      </Typography>
      <div style={{ display: 'flex', justifyContent: 'space-around', marginTop: 20, marginBottom: 20 }}>
        <div>
          <CategoryCard
            category={categories[0]}
            image={categoryImages[categories[0]]}
            onClick={() => handleCategoryClick(categories[0])}
            
          />
        </div>
        <div>
          <CategoryCard
            category={categories[1]}
            image={categoryImages[categories[1]]}
            onClick={() => handleCategoryClick(categories[1])}
          />
        </div>
        <div>
          <CategoryCard
            category={categories[2]}
            image={categoryImages[categories[2]]}
            onClick={() => handleCategoryClick(categories[2])}
          />
        </div>
        <div>
          <CategoryCard
            category={categories[3]}
            image={categoryImages[categories[3]]}
            onClick={() => handleCategoryClick(categories[3])}
          />
        </div>
      </div>
    </Container>
  );
};

export default Category2;
