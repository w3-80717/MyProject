import React, { useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import { Button, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, IconButton, Dialog, DialogTitle, DialogContent, TextField } from '@material-ui/core';
import AddCircleOutlineIcon from '@material-ui/icons/AddCircleOutline';
import DeleteIcon from '@material-ui/icons/Delete';
import EditIcon from '@material-ui/icons/Edit';
import { Container } from '@mui/material';
import goldRing from '../images/goldRing.webp';
import diamondRing from '../images/diamondRing.webp';
import diamondNecklace from '../images/diamondNecklace.webp';
import platinumRing from '../images/platinumRing.png';

const useStyles = makeStyles({
    table: {
        minWidth: 650,
    },
});

const AdminHomePageV2 = () => {
    const classes = useStyles();
    const [products, setProducts] = useState([
        { id: 1, name: 'Gold Ring', price: 70000, image: goldRing },
        { id: 2, name: 'Diamond Ring', price: 270000, image: diamondRing },
        { id: 3, name: 'Diamond Necklace', price: 450000, image: diamondNecklace },
        { id: 4, name: 'Platinum Ring', price: 15000, image: platinumRing },
        
    ]);

    const [openDialog, setOpenDialog] = useState(false);
    const [newProduct, setNewProduct] = useState({ name: '', price: '', image: '' });

    const handleAddProduct = () => {
        setOpenDialog(true);
    };

    const handleCloseDialog = () => {
        setOpenDialog(false);
    };

    const handleSaveProduct = () => {
        // Add validation for newProduct fields
        if (newProduct.name && newProduct.price && newProduct.image) {
            setProducts([...products, { ...newProduct, id: products.length + 1 }]);
            setNewProduct({ name: '', price: '', image: '' });
            setOpenDialog(false);
        } else {
            // Display error message or handle validation
            alert('Please fill all fields');
        }
    };

    const handleUpdateProduct = (id) => {
        
    };

    const handleDeleteProduct = (id) => {
        
    };

    return (
        <Container>
            <div >
                <h1 style={{ textAlign: "center", color: "#832729" }}>Admin Homepage</h1>
                <Button
                    style={{
                        marginBottom: '10px',
                        backgroundColor: "#832729",
                        color: "white"
                    }}
                    variant="contained" onClick={handleAddProduct} startIcon={<AddCircleOutlineIcon />}>
                    Add Product
                </Button>
                <TableContainer component={Paper}>
                    <Table className={classes.table} aria-label="simple table">
                        <TableHead>
                            <TableRow style={{ backgroundColor: "#832729" }}>
                                <TableCell style={{ color: "white" }}>Image</TableCell>
                                <TableCell style={{ color: "white" }}>Name</TableCell>
                                <TableCell style={{ color: "white" }}>Price</TableCell>
                                <TableCell style={{ color: "white" }}>Actions</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {products.map((product) => (
                                <TableRow key={product.id}>
                                    <TableCell>
                                        <img src={product.image} alt={product.name} style={{ width: '50px', height: '50px' }} />
                                    </TableCell>
                                    <TableCell>{product.name}</TableCell>
                                    <TableCell>Rs.{product.price}</TableCell>
                                    <TableCell>
                                        <IconButton style={{ color: "#832729" }} aria-label="edit" onClick={() => handleUpdateProduct(product.id)}>
                                            <EditIcon />
                                        </IconButton>
                                        <IconButton style={{ color: "#832729" }} aria-label="delete" onClick={() => handleDeleteProduct(product.id)}>
                                            <DeleteIcon />
                                        </IconButton>
                                    </TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>
            </div>

            <Dialog open={openDialog} onClose={handleCloseDialog} aria-labelledby="form-dialog-title">
                <DialogTitle id="form-dialog-title">Add Product</DialogTitle>
                <DialogContent>
                    <TextField
                        autoFocus
                        margin="dense"
                        id="name"
                        label="Name"
                        fullWidth
                        value={newProduct.name}
                        onChange={(e) => setNewProduct({ ...newProduct, name: e.target.value })}
                    />
                    <TextField
                        margin="dense"
                        id="price"
                        label="Price"
                        fullWidth
                        value={newProduct.price}
                        onChange={(e) => setNewProduct({ ...newProduct, price: e.target.value })}
                    />
                    <TextField
                        margin="dense"
                        id="image"
                        label="Image URL"
                        fullWidth
                        value={newProduct.image}
                        onChange={(e) => setNewProduct({ ...newProduct, image: e.target.value })}
                    />
                </DialogContent>
                <Button onClick={handleSaveProduct} color="primary">
                    Add
                </Button>
            </Dialog>
        </Container>
    );
};

export default AdminHomePageV2;
