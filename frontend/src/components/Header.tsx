import React from "react";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Image from 'mui-image'
import Logo from "../assets/guru-cartoon.png";

const Header: React.FC = () => {
  return (
    <AppBar
      sx={{
        background: "#ffffff",
        color: "#000000",
      }}
      position="static"
    >
      <Toolbar className="header">
        <Image
          src={Logo}
          className="logo"
          height="65px"
          width="75px"
          alt="logo"
        />
        <Typography
          variant="h6"
          component="div"
          sx={{ flexGrow: 1, marginLeft: "16px" }}
        >
          When decision fatigue gets the best of you
        </Typography>
      </Toolbar>
    </AppBar>
  );
};

export default Header;
