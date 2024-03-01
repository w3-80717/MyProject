import React, { useEffect, useState } from 'react';
import Navbar from '../components/Navbar';
import { Button, Container, IconButton } from '@mui/material';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from '@material-ui/core';
import axios from 'axios';
import config from '../config';
import DeleteIcon from '@material-ui/icons/Delete';
import { useNavigate } from 'react-router-dom';


const Cart = () => {

    const [cartItems, setCartItems] = useState([]);
    const [totalPrice, setTotalPrice] = useState(0);
    const navigate = useNavigate();

    useEffect(() => {
        fetchCartItems();
    }, []);

    useEffect(() => {
        // Calculate total price whenever cartItems changes
        calculateTotalPrice();
    }, [cartItems]);

    const calculateTotalPrice = () => {
        const total = cartItems.reduce((acc, item) => { console.log(acc,item.price); return acc + item.product.price;}, 0);
        setTotalPrice(total);
    };

    const fetchCartItems = async () => {
        try {
            const response = await axios.get(`${config.server}/api/customer/cart`);
            console.log(response.data);
            setCartItems(response.data.items);
        } catch (error) {
            console.error('Error fetching cart:', error);
        }
    };

    const handleDeleteProduct = async (id) => {
        try {
            await axios.delete(`${config.server}/api/customer/cart/${id}`);
            console.log("id", id);
            fetchCartItems();
        } catch (error) {
            console.error('Error deleting cart item:', error);
            alert('An error occurred while deleting the cart item.');
        }
    };

    const handlePlaceOrder = () => {
        // Navigate to ThankYou page
        navigate('/placed');
    };

    const handleContinueShopping = () => {
        // Navigate to home page
        navigate('/home');
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
                            {cartItems.map((item, index) => (
                                <TableRow key={index}>
                                    <TableCell>
                                        <img src={config.server + '/' + item.image} alt={item.product.name} style={{ width: '50px', height: '50px' }} />
                                    </TableCell>
                                    <TableCell>{item.product.pname}</TableCell>
                                    <TableCell>{item.product.price}</TableCell>
                                    <TableCell>
                                        <IconButton style={{ color: "#832729" }} aria-label="delete" onClick={() => {
                                            handleDeleteProduct(item.ciid);
                                            console.log("id line 81", item.cartId);
                                        }}>
                                            <DeleteIcon />
                                        </IconButton></TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                        <TableBody>
                            <TableRow>
                                <TableCell colSpan={2} />
                                <TableCell>Total:</TableCell>
                                <TableCell>{totalPrice}</TableCell>
                            </TableRow>
                        </TableBody>
                    </Table>
                </TableContainer>
                <div style={{display: "flex", justifyContent: "space-around", marginTop: "20px"}}>
                <Button variant="contained" style={{backgroundColor: "#832729"}} onClick={handlePlaceOrder}>Place Order</Button>
                <Button variant="contained" style={{backgroundColor: "#832729"}} onClick={handleContinueShopping}>Continue Shopping</Button>
                </div>
            </Container>
        </>
    );
}

export default Cart;
