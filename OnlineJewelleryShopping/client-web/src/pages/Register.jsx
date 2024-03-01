import React, { useState } from 'react';
import { TextField, Button, Container, Typography, Box } from '@mui/material';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';
import config from '../config';

const Register = () => {
  const [name, setName] = useState('');
  const [mobile, setMobile] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [address, setAddress] = useState('');
  const navigate = useNavigate();

  const handleRegister = async () => {
    if (!name || !mobile || !email || !password || !address) {
      alert('Please fill in all fields.');
      return;
    }
    try {
      const response = await axios.post(`${config.server}/api/user/register`, {
        uname: name,
        mobile,
        email,
        password,
        address,
      });
      console.log(response.data); // Assuming the response contains useful information
      navigate('/');

    } catch (error) {
      console.error('Error registering:', error);
      alert('Registration failed. Please try again.');
    }
  };

  return (
    <Container component="main" maxWidth="xs">
      <Box
        sx={{
          marginTop: 8,
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center',
        }}
      >
        <Typography style={{ color: '#832729', fontWeight: 'bold' }} component="h1" variant="h4">
          Register
        </Typography>
        <Box component="form" noValidate sx={{ mt: 1 }}>
          <TextField
            label="Name"
            fullWidth
            margin="normal"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <TextField
            label="Mobile"
            fullWidth
            margin="normal"
            value={mobile}
            onChange={(e) => setMobile(e.target.value)}
          />
          <TextField
            label="Email"
            fullWidth
            margin="normal"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <TextField
            label="Password"
            fullWidth
            margin="normal"
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <TextField
            label="Address"
            fullWidth
            multiline
            rows={3}
            margin="normal"
            value={address}
            onChange={(e) => setAddress(e.target.value)}
          />
          <Button
            style={{ backgroundColor: '#832729' }}
            type="button"
            fullWidth
            variant="contained"
            onClick={handleRegister}
            sx={{ mt: 3, mb: 2 }}
          >
            Register
          </Button>
          <Typography sx={{ mt: 2 }}>
            Have got an account? <Link to="/">Login now</Link>
          </Typography>

          <Typography sx={{ mt: 2 }}>
            Go to homepage... <Link to="/home">Skip</Link>
          </Typography>
        </Box>
      </Box>
    </Container>
  );
};

export default Register;
