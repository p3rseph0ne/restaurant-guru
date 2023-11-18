import Header from "../components/Header";
import { Button } from "@mui/material";
import { Box } from "@mui/system";
import { useNavigate } from "react-router";
import Background from "../assets/stage.png"
import { Outlet } from "react-router-dom";

export default function Page() {

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
        <Outlet />
      </Box>
    </div>
  );
}
