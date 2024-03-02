import React, { useEffect, useState } from 'react';
import { Grid, Card, CardContent, CardMedia, Typography, Button, IconButton, Badge } from '@material-ui/core';
import Navbar from '../components/Navbar';
import { Container } from '@mui/material';
import { Link } from 'react-router-dom';
import axios from 'axios';
import config from '../config';
import { Favorite } from '@material-ui/icons';

const Necklace = () => {
    const [necklaceProducts, setNecklaceProducts] = useState([]);

    useEffect(() => {
        fetchNecklaceProducts();
    }, []);

    const fetchNecklaceProducts = async () => {
            try {
                const response = await axios.get(`${config.server}/api/customer/products`);
                setNecklaceProducts(response.data.filter(p => p.subCategory.sid==1));
            } catch (error) {
                console.error('Error fetching products:', error);
            }
    };

    const addToCart = async (pid) => {
        try {
            // Make a request to your backend to add the product to the cart table
            const response = await axios.post(`${config.server}/api/customer/addcart/${pid}/1`);
            console.log(response.data);
            // Optionally, you can display a success message or update the UI to reflect the product being added to the cart
        } catch (error) {
            console.error('Error adding product to cart:', error);
            alert("Error adding product to cart");
        }
    };

    const addToWishlist = async (pid) => {
        try {
            // Make a request to your backend to add the product to the cart table
            const response = await axios.post(`${config.server}/api/customer/addwishlist/${pid}`);
            console.log(response.data);
            // Optionally, you can display a success message or update the UI to reflect the product being added to the cart
        } catch (error) {
            console.error('Error adding product to wishlist:', error);
            alert("Error adding product to wishlist");
        }
    };

    return (
        <>
            <Navbar />
            <Container>
                <Grid container spacing={3} style={{ marginTop: 10 }}>
                    {necklaceProducts.map((product, index) => (
                        <Grid item xs={12} sm={6} md={3} key={index}>
                            <Card>
                                <CardMedia
                                    component="img"
                                    alt={product.pname}
                                    height="140"
                                    image={config.server + product.image}
                                />
                                <CardContent>
                                    <Typography variant="h5" component="h2" style={{ color: "#832729", fontWeight: "bold" }}>
                                        {product.pname}
                                    </Typography>
                                    <Typography variant="subtitle1" color="inherit" component="p">
                                        Price: ₹{product.price}
                                    </Typography>
                                    <div style={{ display: "flex", justifyContent: "space-between" }}>
                                        <Button
                                            variant='outlined'
                                            component={Link}
                                            to="/cart"
                                            style={{ color: "#832729", fontWeight: "bold", marginBottom: "-15px", height: "45px" }}
                                            onClick={() => addToCart(product.pid)}
                                        >
                                            Add to Cart
                                        </Button>
                                        <IconButton
                                            style={{ color: "#832729" }}
                                            component={Link}
                                            to="/wishlist"
                                            onClick={() => addToWishlist(product.pid)}
                                        >
                                            <Badge badgeContent={0} color="error">
                                                <Favorite />
                                            </Badge>
                                        </IconButton>
                                    </div>
                                </CardContent>
                            </Card>
                        </Grid>
                    ))}
                </Grid>
            </Container>
        </>
    );
}

export default Necklace;
