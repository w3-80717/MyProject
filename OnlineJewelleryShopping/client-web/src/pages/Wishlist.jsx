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
            const response = await axios.get(`${config.server}/wishlist`);
            console.log(response.data);
            setWishlistItems(response.data.data);
        } catch (error) {
            console.error('Error fetching cart:', error);
        }
    };

    const addToCart = async (pid) => {
        try {
            // Make a request to your backend to add the product to the cart table
            const response = await axios.post(`${config.server}/cart`, {
                pid: pid
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
          await axios.delete(`${config.server}/wishlist/${id}`);
          fetchWishlistItems(); // Refresh the product list after deleting
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
                                <TableCell style={{color: "white"}}>Image</TableCell>
                                <TableCell style={{color: "white"}}>Name</TableCell>
                                <TableCell style={{color: "white"}}>Price</TableCell>
                                <TableCell style={{color: "white"}}>Actions</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {wishlistItems.map((item, index) => (
                                <TableRow key={index}>
                                    <TableCell>
                                        <img src={config.server + '/' + item.image} alt={item.pname} style={{ width: '50px', height: '50px' }} />
                                    </TableCell>
                                    <TableCell>{item.pname}</TableCell>
                                    <TableCell>{item.price}</TableCell>
                                    <TableCell>
                                        
                                        <Button
                                            variant='outlined'
                                            component={Link}
                                            to="/cart"
                                            style={{ color: "#832729", fontWeight: "bold", }}
                                            onClick={() => addToCart(item.pid)}
                                        >
                                            Add to Cart
                                        </Button>
                                        <IconButton style={{ color: "#832729" }} aria-label="delete" onClick={() => handleDeleteProduct(item.wid)}>
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
