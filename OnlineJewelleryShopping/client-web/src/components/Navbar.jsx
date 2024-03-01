import { AppBar, Toolbar, IconButton, Badge, Container, Typography } from '@mui/material';
import AccountCircle from '@mui/icons-material/AccountCircle';
import ShoppingCart from '@mui/icons-material/ShoppingCart';
import Favorite from '@mui/icons-material/Favorite';
import ExitToApp from '@mui/icons-material/ExitToApp';
import Logo from '../images/logo.png'; 
import { Link } from 'react-router-dom';

function Navbar() {
    return (
        <>
            <AppBar position="static" sx={{ backgroundColor: '#660000 ' }}>
                <Container>
                    <Toolbar>
                        
                        <IconButton edge="start" color="inherit" aria-label="menu" component={Link} to="/home">
                            <img src={Logo} alt="Logo" style={{ width: 40, height: 40 }} />
                        </IconButton>

                        
                        <div style={{ flexGrow: 1 }}>
                            <div style={{ display: 'flex', alignItems: 'center', paddingLeft: 16 }}>
                                
                                <Typography>
                                    Jewellery Store
                                </Typography>
                            </div>
                        </div>

                        
                        <IconButton color="inherit" component={Link} to="/wishlist" >
                            <Badge badgeContent={0} color="error">
                                <Favorite />
                            </Badge>
                        </IconButton>
                        <IconButton color="inherit" component={Link} to="/cart" >
                            <Badge badgeContent={0} color="error">
                                <ShoppingCart />
                            </Badge>
                        </IconButton>
                        <IconButton color="inherit" component={Link} to="/profile">
                            <AccountCircle />
                        </IconButton>
                        <IconButton color="inherit" component={Link} to="/">
                            <ExitToApp />
                        </IconButton>
                    </Toolbar>
                </Container>
            </AppBar>
            
        </>
    );
}

export default Navbar;