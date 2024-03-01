import React from 'react';
import Navbar from '../components/Navbar';
import { Avatar, Grid, Typography, TextField } from '@material-ui/core';
import profileImg from '../images/nitaAmbani.jpg'
// import profileImg from '../images/profile.jpg'

const Profile = () => {
    
    const profileData = {
        name: 'Nita Ambani',
        mobile: '+910000000009',
        email: 'user@gmail.com',
        address: '123 Main Street, City, Country',
        profileImage: profileImg,
    };

    return (
        <>
            <Navbar />
            <Grid container spacing={3} justify="center" alignItems="center" style={{ marginTop: "10px" }}>
                <Grid item xs={12} sm={6} md={4}>
                    <Avatar alt={profileData.name} src={profileData.profileImage} style={{ width: '150px', height: '150px', margin: 'auto' }} />
                    <Typography variant="h5" gutterBottom style={{ textAlign: 'center' }}>
                        {profileData.name}
                    </Typography>
                    <TextField
                        label="Mobile"
                        variant="filled"
                        fullWidth
                        margin="normal"
                        value={profileData.mobile}
                        InputProps={{
                            readOnly: true,
                        }}
                    />
                    <TextField
                        label="Email"
                        variant="filled"
                        fullWidth
                        margin="normal"
                        value={profileData.email}
                        InputProps={{
                            readOnly: true,
                        }}
                    />
                    <TextField
                        label="Address"
                        variant="filled"
                        fullWidth
                        margin="normal"
                        value={profileData.address}
                        InputProps={{
                            readOnly: true,
                        }}
                    />
                </Grid>
            </Grid>
        </>
    );
}

export default Profile;
