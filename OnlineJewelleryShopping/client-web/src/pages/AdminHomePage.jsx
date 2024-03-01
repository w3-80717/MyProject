import React, { useState, useEffect } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import { Button, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, IconButton, Dialog, DialogTitle, DialogContent, TextField } from '@material-ui/core';
import AddCircleOutlineIcon from '@material-ui/icons/AddCircleOutline';
import DeleteIcon from '@material-ui/icons/Delete';
import EditIcon from '@material-ui/icons/Edit';
import { Container, Typography } from '@mui/material';
import axios from 'axios';
import config from '../config';

const useStyles = makeStyles({
  table: {
    minWidth: 650,
  },
});

const AdminHomePage = () => {
  const classes = useStyles();
  const [products, setProducts] = useState([]);
  const [openAddDialog, setOpenAddDialog] = useState(false);
  const [openUpdateDialog, setOpenUpdateDialog] = useState(false);
  const [newProduct, setNewProduct] = useState({ pname: '', price: '', image: '' });
  // const [updatedPrice, setUpdatedPrice] = useState('');
  const [selectedProductId, setSelectedProductId] = useState('');
  const [newPrice, setNewPrice] = useState('');

  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = async () => {
    try {
      const response = await axios.get(`${config.server}/api/admin`);
      console.log(response.data);
      console.log("Image", response.data.image);
      setProducts(response.data);
    } catch (error) {
      console.error('Error fetching products:', error);
    }
  };

  const handleAddProduct = () => {
    setOpenAddDialog(true);
  };

  const handleCloseAddDialog = () => {
    setOpenAddDialog(false);
  };

  const handleCloseUpdateDialog = () => {
    setOpenUpdateDialog(false);
  };


  const handleSaveProduct = async () => {
    try {
      const formData = new FormData();
      formData.append('pname', newProduct.pname);
      formData.append('price', newProduct.price);
      formData.append('image', newProduct.image); // Append the image file to the FormData object

      formData.append('cid', newProduct.cid); // cid
      formData.append('sid', newProduct.sid); // sid

      await axios.post(`${config.server}/api/admin`, formData, {
        headers: {
          'Content-Type': 'multipart/form-data', // Set the Content-Type header to multipart/form-data for file upload
        },
      });
      fetchProducts();
      setNewProduct({ pname: '', price: '', image: '', cid: '', sid: '' });
      setOpenAddDialog(false);
    } catch (error) {
      console.error('Error saving product:', error);
      alert('An error occurred while saving the product.');
    }
  };

  const handleImageChange = (e) => {
    const file = e.target.files[0]; // Get the first file selected by the user
    setNewProduct({ ...newProduct, image: file });
  };

  const handleUpdateProduct = (productId, price) => {
    setSelectedProductId(productId);
    setNewPrice(price);
    setOpenUpdateDialog(true);
  };

  const handleConfirmUpdate = async (id) => {
    try {
      await axios.put(`${config.server}/api/admin/${selectedProductId}`, { price: newPrice });
      fetchProducts(); // Refresh the product list after updating
      setOpenUpdateDialog(false);
    } catch (error) {
      console.error('Error updating product:', error);
      alert('An error occurred while updating the product.');
    }
  };

  const handleDeleteProduct = async (id) => {
    try {
      await axios.delete(`${config.server}/api/admin/${id}`);
      fetchProducts(); // Refresh the product list after deleting
    } catch (error) {
      console.error('Error deleting product:', error);
      alert('An error occurred while deleting the product.');
    }
  };

  return (
    <Container style={{ marginBottom: "50px" }}>
      <div>
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
                <TableCell style={{ color: "white" }}>Category</TableCell>
                <TableCell style={{ color: "white" }}>Sub Category</TableCell>
                <TableCell style={{ color: "white" }}>Actions</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {products.map((product) => (
                <TableRow key={product.pid}>
                  <TableCell>
                    <img src={config.server + '/' + product.image} alt={product.pname} style={{ width: '70px', height: '70px' }} />
                  </TableCell>
                  <TableCell>{product.pname}</TableCell>
                  <TableCell>{"₹ " + product.price}</TableCell>
                  <TableCell>{product.category.cname}</TableCell>
                  <TableCell>{product.subCategory.sname}</TableCell>
                  <TableCell>
                    <IconButton style={{ color: "#832729" }} aria-label="edit" onClick={() => handleUpdateProduct(product.pid, product.price)}>
                      <EditIcon />
                    </IconButton>
                    <IconButton style={{ color: "#832729" }} aria-label="delete" onClick={() => handleDeleteProduct(product.pid)}>
                      <DeleteIcon />
                    </IconButton>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </div>

      <Dialog open={openAddDialog} onClose={handleCloseAddDialog} aria-labelledby="form-dialog-title">
        <DialogTitle id="form-dialog-title">Add Product</DialogTitle>
        <DialogContent>
          <TextField
            autoFocus
            margin="dense"
            id="pname"
            label="Name"
            fullWidth
            value={newProduct.pname}
            onChange={(e) => setNewProduct({ ...newProduct, pname: e.target.value })}
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
            label="Image"
            type="file"
            fullWidth
            onChange={handleImageChange}
          />
          <Typography variant="subtitle2" color="red" component="p">
            Hint: Enter<br />
            1 for Gold,<br />
            2 for Silver,<br />
            3 for Diamond,<br />
            4 for Platinum
          </Typography>
          <TextField
            margin="dense"
            id="cid"
            label="Category ID"
            fullWidth
            value={newProduct.cid}
            onChange={(e) => setNewProduct({ ...newProduct, cid: e.target.value })}
          />
          <Typography variant="subtitle2" color="red" component="p">
            Hint: Enter<br />
            1 for Necklace,<br />
            2 for Ring,<br />
            3 for Earring,<br />
            4 for Nose Ring
          </Typography>
          <TextField
            margin="dense"
            id="sid"
            label="Sub Category ID"
            fullWidth
            value={newProduct.sid}
            onChange={(e) => setNewProduct({ ...newProduct, sid: e.target.value })}
          />

        </DialogContent>
        <Button onClick={handleSaveProduct} >
          Add
        </Button>
      </Dialog>

      <Dialog open={openUpdateDialog} onClose={handleCloseUpdateDialog} aria-labelledby="form-dialog-title">
        <DialogTitle id="form-dialog-title">Update Product Price</DialogTitle>
        <DialogContent>
          <TextField
            autoFocus
            margin="dense"
            id="price"
            label="New Price"
            type="number"
            fullWidth
            value={newPrice}
            onChange={(e) => setNewPrice(e.target.value)}
          />
        </DialogContent>
        <Button onClick={handleConfirmUpdate} color="primary">
          Update
        </Button>
        <Button onClick={handleCloseUpdateDialog} color="primary">
          Cancel
        </Button>
      </Dialog>

    </Container>
  );
};

export default AdminHomePage;
