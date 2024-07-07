import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { TextField, Button, Container, Typography, Box } from '@mui/material';
import axios from 'axios';
import config from '../config';

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = () => {
    axios.post(`${config.server}/api/login`, { email, password })
      .then(response => {
        const { status, role, sessionId } = response.data;
        console.log(response.headers)
        if (status === 'success' && sessionId) {
          localStorage.setItem('sessionId', sessionId); // Store user ID in local storage
          if (role === 'admin') {
            navigate('/admin');
          } else {
            navigate('/home');
          }
          console.log('Email:', email);
          console.log('Password:', password);
        } else {
          alert('Invalid credentials');
        }
      })
      .catch(error => {
        console.error('Login error:', error);
        alert('An error occurred while logging in');
      });
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
        <Typography style={{ color: "#832729", fontWeight: "bold" }} component="h1" variant="h4">
          Login
        </Typography>
        <Box component="form" noValidate sx={{ mt: 1 }}>
          <TextField
            margin="normal"
            required
            fullWidth
            id="email"
            label="Email"
            name="email"
            autoComplete="email"
            autoFocus
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <TextField
            margin="normal"
            required
            fullWidth
            name="password"
            label="Password"
            type="password"
            id="password"
            autoComplete="current-password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <Button
            style={{ backgroundColor: "#832729" }}
            type="button"
            fullWidth
            variant="contained"
            onClick={handleLogin}
            sx={{ mt: 3, mb: 2 }}
          >
            Login
          </Button>
        </Box>

        <Typography sx={{ mt: 2 }}>
          Don't have an account? <Link to="/register">Register now</Link>
        </Typography>

        <Typography sx={{ mt: 2 }}>
          Go to homepage..
          <Link to="/home">Skip</Link>
        </Typography>

      </Box>
    </Container>
  );
};

export default Login;
