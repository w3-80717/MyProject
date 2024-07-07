import React, { useEffect, useState } from 'react';
import Navbar from '../components/Navbar';
import { Button, Container } from '@mui/material';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, IconButton } from '@material-ui/core';
import axios from 'axios';
import config from '../config';
import DeleteIcon from '@material-ui/icons/Delete';
import { Link } from 'react-router-dom';

const Wishlist = () => {
    const [wishlistItems, setWishlistItems] = useState([]);

    useEffect(() => {
        fetchWishlistItems();
    }, []);

    const fetchWishlistItems = async () => {
        try {
            const sessionId = localStorage.getItem('sessionId'); // Retrieve session ID from localStorage
            const response = await axios.get(`${config.server}/api/customer/wishlist`, {
                headers: {
                    'Authorization': sessionId, // Set session ID in the Authorization header
                },
                withCredentials: true, // Include credentials for CORS
            });
            console.log(response.data);
            setWishlistItems(response.data.items);
        } catch (error) {
            console.error('Error fetching wishlist items:', error);
        }
    };

    const addToCart = async (pid) => {
        try {
            const sessionId = localStorage.getItem('sessionId'); // Retrieve session ID from localStorage
            const response = await axios.post(`${config.server}/api/customer/addcart/${pid}/1`, {}, {
                headers: {
                    'Authorization': sessionId, // Set session ID in the Authorization header
                },
                withCredentials: true, // Include credentials for CORS
            });
            console.log(response.data);
            // Optionally, you can display a success message or update the UI to reflect the product being added to the cart
        } catch (error) {
            console.error('Error adding product to cart:', error);
            alert("Error adding product to cart");
        }
    };

    const handleDeleteProduct = async (id) => {
        try {
            const sessionId = localStorage.getItem('sessionId'); // Retrieve session ID from localStorage
            await axios.delete(`${config.server}/api/customer/wishlist/${id}`, {
                headers: {
                    'Authorization': sessionId, // Set session ID in the Authorization header
                },
                withCredentials: true, // Include credentials for CORS
            });
            fetchWishlistItems(); // Refresh the wishlist items after deleting
        } catch (error) {
            console.error('Error deleting wishlist item:', error);
            alert('An error occurred while deleting the wishlist item.');
        }
    };

    return (
        <>
            <Navbar />
            <Container style={{ marginTop: "10px", marginBottom: "10px" }}>
                <TableContainer component={Paper}>
                    <Table>
                        <TableHead>
                            <TableRow style={{ backgroundColor: "#832729" }}>
                                <TableCell style={{ color: "white" }}>Image</TableCell>
                                <TableCell style={{ color: "white" }}>Name</TableCell>
                                <TableCell style={{ color: "white" }}>Price</TableCell>
                                <TableCell style={{ color: "white" }}>Actions</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {wishlistItems.map((item, index) => (
                                <TableRow key={index}>
                                    <TableCell>
                                        <img src={config.server + item.product.image} alt={item.product.pname} style={{ width: '50px', height: '50px' }} />
                                    </TableCell>
                                    <TableCell>{item.product.pname}</TableCell>
                                    <TableCell>{item.product.price}</TableCell>
                                    <TableCell>
                                        <Button
                                            variant='outlined'
                                            component={Link}
                                            to="/cart"
                                            style={{ color: "#832729", fontWeight: "bold" }}
                                            onClick={() => addToCart(item.product.pid)}
                                        >
                                            Add to Cart
                                        </Button>
                                        <IconButton style={{ color: "#832729" }} aria-label="delete" onClick={() => handleDeleteProduct(item.wiid)}>
                                            <DeleteIcon />
                                        </IconButton>
                                    </TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>
            </Container>
        </>
    );
}

export default Wishlist;
