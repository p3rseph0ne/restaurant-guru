import Header from "../components/Header";
import { Button, FormControlLabel, TextField, Link } from "@mui/material";
import CheckboxMUI from "@mui/material/Checkbox";
import { Box } from "@mui/system";
import { useNavigate } from "react-router";
import Background from "../assets/stage.png"

export default function Root() {
  const navigate = useNavigate();

  return (
    <div className="pagecontainer">
      <Header />
      <Box className="formcontainer" sx={{
          backgroundImage: `url(${Background})`,
          backgroundSize: 'cover', // Ensures the background covers the whole Box
          backgroundPosition: 'center', // Centers the background image
          backgroundRepeat: 'no-repeat', // Prevents repeating the background image
          height:  'calc(100vh - 100px)'
        }}>
        <div className="form">
          <div className="flex-container"></div>
          <h3>Wachu wanna do sweetcheeks?</h3>
          <div>
            <Button variant="contained" onClick={() => navigate('/person')}>I really really really wanna create a Person!</Button>
          </div>
          <div>
            <Button variant="contained" onClick={() => navigate('/restaurant')}> 
                    Nah man tell me what I should eat
            </Button>
          </div>
        </div>
      </Box>
    </div>
  );
}
