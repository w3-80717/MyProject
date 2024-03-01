import { Container, Typography, Button, Avatar } from "@mui/material";
import { makeStyles } from '@material-ui/core/styles';
import Navbar from "../components/Navbar";
import thankYouImg from "../images/thankyou.webp"; // Assuming you have a component for circular images

const useStyles = makeStyles((theme) => ({
    container: {
        textAlign: "center",
        marginTop: theme.spacing(4),
    },
    message: {
        marginTop: theme.spacing(2),
    },
    continueButton: {
        marginTop: theme.spacing(4),
    },
}));

function ThankYou() {
    const classes = useStyles();

    const imageData = {
        
        thankYouImage: thankYouImg,
    };

    return (
        <>
            <Navbar />
            <Container className={classes.container}>
                <Avatar src={imageData.thankYouImage} style={{ width: '250px', height: '250px', margin: 'auto' }} />
                <Typography variant="h3" style={{ color: "#832729", fontWeight: "bold", marginTop: "20px" }} >
                    Order Placed
                </Typography>
                <Typography variant="h4" style={{ color: "#832729", marginTop: "20px" }} >
                    Thank you for shopping with us
                </Typography>
                <Button variant="contained" style={{ backgroundColor: "#832729", marginTop: "20px" }} className={classes.continueButton}>
                    Continue Shopping
                </Button>
            </Container>
        </>
    );
}

export default ThankYou;
