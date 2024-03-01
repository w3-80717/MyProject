import React from 'react';
import { Grid, Card, CardContent, CardMedia, Typography, Button } from '@material-ui/core';
import necklaceImg from '../images/necklace.jpeg';
import ringImg from '../images/ring.jpeg';
import earringImg from '../images/earring.jpeg';
import noseringImg from '../images/nosering.jpeg';
import { Link } from 'react-router-dom';

const FourCardGridSubCategory = () => {
    return (
        <>
        <Typography variant="h4" align="center" style={{ margin: 20, color: "#832729", fontWeight: "bold" }}>
        Shop by Sub Category
        </Typography>
        <Grid container spacing={3}>
            <Grid item xs={12} sm={6} md={3}>
                <Card>
                    <CardMedia
                        component="img"
                        alt="Necklace"
                        height="140"
                        image={necklaceImg}
                        title="Necklace"
                    />
                    <CardContent>
                        <Typography variant="h5" component="h2" style={{color: "#832729", fontWeight: "bold"}} >
                            Necklace
                        </Typography>
                        <Button 
                            variant='outlined' 
                            component= {Link}
                            to="/home/necklace"
                            style={{color: "#832729" }}>
                                Explore
                        </Button>
                    </CardContent>
                </Card>
            </Grid>
            <Grid item xs={12} sm={6} md={3}>
                <Card>
                    <CardMedia
                        component="img"
                        alt="Ring"
                        height="140"
                        image={ringImg}
                        title="Ring"
                    />
                    <CardContent>
                        <Typography variant="h5" component="h2" style={{color: "#832729", fontWeight: "bold"}} >
                            Ring
                        </Typography>
                        <Button 
                            variant='outlined' 
                            component= {Link}
                            to="/home/ring"
                            style={{color: "#832729" }}>
                                Explore
                        </Button>
                    </CardContent>
                </Card>
            </Grid>
            <Grid item xs={12} sm={6} md={3}>
                <Card>
                    <CardMedia
                        component="img"
                        alt="Earring"
                        height="140"
                        image={earringImg}
                        title="Earring"
                    />
                    <CardContent>
                        <Typography variant="h5" component="h2" style={{color: "#832729", fontWeight: "bold"}} >
                            Earring
                        </Typography>
                        <Button 
                            variant='outlined' 
                            component= {Link}
                            to="/home/earring"
                            style={{color: "#832729" }}>
                                Explore
                        </Button>
                    </CardContent>
                </Card>
            </Grid>
            <Grid item xs={12} sm={6} md={3}>
                <Card>
                    <CardMedia
                        component="img"
                        alt="Nose Ring"
                        height="140"
                        image={noseringImg}
                        title="Nose Ring"
                    />
                    <CardContent>
                        <Typography variant="h5" component="h2" style={{color: "#832729", fontWeight: "bold"}} >
                            Nose Ring
                        </Typography>
                        <Button 
                            variant='outlined' 
                            component= {Link}
                            to="/home/nosering"
                            style={{color: "#832729" }}>
                                Explore
                        </Button>
                    </CardContent>
                </Card>
            </Grid>
        </Grid>
        </>
    );
}

export default FourCardGridSubCategory;
