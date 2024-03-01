import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';

import Login from './pages/Login';
import Register from './pages/Register';
import Home from './pages/Home';
import Gold from './pages/Gold';
import Silver from './pages/Silver';
import Diamond from './pages/Diamond';
import Platinum from './pages/Platinum';
import Wishlist from './pages/Wishlist';
import Cart from './pages/Cart';
import Profile from './pages/Profile';
import AdminHomePage from './pages/AdminHomePage';
import Necklace from './pages/Necklace';
import Ring from './pages/Ring';
import Earring from './pages/Earring';
import NoseRing from './pages/NoseRing';
import ThankYou from './pages/ThankYou';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>

    <Router>
      <Routes>
        <Route path='/' element={<Login />} />
        <Route path='/register' element={<Register />} />

        {/* <Route path='/' element={<Home />} /> */}

        <Route path='/home' element={<Home />} />
        <Route path="/home/gold" element={<Gold />} />
        <Route path="/home/silver" element={<Silver />} />
        <Route path="/home/diamond" element={<Diamond />} />
        <Route path="/home/platinum" element={<Platinum />} />

        <Route path="/home/necklace" element={<Necklace />} />
        <Route path="/home/ring" element={<Ring />} />
        <Route path="/home/earring" element={<Earring />} />
        <Route path="/home/nosering" element={<NoseRing />} />

        <Route path="/wishlist" element={<Wishlist />} />
        <Route path="/cart" element={<Cart />} />
        <Route path="/profile" element={<Profile />} />
        <Route path="/admin" element={<AdminHomePage />} />

        <Route path="/placed" element={<ThankYou />} />

      </Routes>
    </Router>
  </React.StrictMode>
);

reportWebVitals();