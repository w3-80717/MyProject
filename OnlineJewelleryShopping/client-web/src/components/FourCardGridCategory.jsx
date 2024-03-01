import React from 'react';
import { Grid, Card, CardContent, CardMedia, Typography, Button } from '@material-ui/core';
import goldImg from '../images/gold.jpg';
import silverImg from '../images/silver.jpg';
import diamondImg from '../images/diamond.png';
import platinumImg from '../images/platinum.jpg';
import { Link } from 'react-router-dom';

const FourCardGridCategory = () => {
    return (
        <>
            <Typography variant="h4" align="center" style={{ marginBottom: 20, color: "#832729", fontWeight: "bold" }}>
                Shop by Category
            </Typography>
            <Grid container spacing={3}>
                <Grid item xs={12} sm={6} md={3}>
                    <Card>
                        <CardMedia
                            component="img"
                            alt="Gold"
                            height="140"
                            image={goldImg}
                            
                        />
                        <CardContent>
                            <Typography variant="h5" component="h2" style={{ color: "#832729", fontWeight: "bold" }} >
                                Gold
                            </Typography>
                            <Button
                                variant='outlined'
                                component={Link}
                                to="/home/gold"
                                style={{ color: "#832729" }} >
                                Explore
                            </Button>
                        </CardContent>
                    </Card>
                </Grid>
                <Grid item xs={12} sm={6} md={3}>
                    <Card>
                        <CardMedia
                            component="img"
                            alt="Silver"
                            height="140"
                            image={silverImg}
                            
                        />
                        <CardContent>
                            <Typography variant="h5" component="h2" style={{ color: "#832729", fontWeight: "bold" }} >
                                Silver
                            </Typography>
                            <Button
                                variant='outlined'
                                component={Link}
                                to="/home/silver"
                                style={{ color: "#832729" }} >
                                Explore
                            </Button>
                        </CardContent>
                    </Card>
                </Grid>
                <Grid item xs={12} sm={6} md={3}>
                    <Card>
                        <CardMedia
                            component="img"
                            alt="Diamond"
                            height="140"
                            image={diamondImg}
                            
                        />
                        <CardContent>
                            <Typography variant="h5" component="h2" style={{ color: "#832729", fontWeight: "bold" }} >
                                Diamond
                            </Typography>
                            <Button
                                variant='outlined'
                                component={Link}
                                to="/home/diamond"
                                style={{ color: "#832729" }} >
                                Explore
                            </Button>
                        </CardContent>
                    </Card>
                </Grid>
                <Grid item xs={12} sm={6} md={3}>
                    <Card>
                        <CardMedia
                            component="img"
                            alt="Platinum"
                            height="140"
                            image={platinumImg}
                            
                        />
                        <CardContent>
                            <Typography variant="h5" component="h2" style={{ color: "#832729", fontWeight: "bold" }} >
                                Platinum
                            </Typography>
                            <Button
                                variant='outlined'
                                component={Link}
                                to="/home/platinum"
                                style={{ color: "#832729" }} >
                                Explore
                            </Button>
                        </CardContent>
                    </Card>
                </Grid>
            </Grid>
        </>
    );
}

export default FourCardGridCategory;
