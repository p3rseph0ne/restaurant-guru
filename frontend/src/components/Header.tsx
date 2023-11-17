import React from "react";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Image from 'mui-image'
import Logo from "../assets/logo.png";
import { useNavigate } from "react-router";
import { Box } from "@mui/system";
import { Button } from "@mui/material";

const Header: React.FC = () => {
  const navigate = useNavigate();

  return (
    <AppBar
      sx={{
        background: "#1c1a1a",
        color: "#000000",
      }}
      position="static"
    >
      <Toolbar className="header"
        sx={{
          display: 'flex',
          flexDirection: 'row',
          justifyContent: 'space-between'
        }}
        >
        <Image
          src={Logo}
          className="logo"
          height="100px"
          width="75px"
          alt="logo"
        />
        <Box>
        </Box>
      </Toolbar>
    </AppBar>
  );
};

export default Header;
