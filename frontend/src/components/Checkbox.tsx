import React from "react"
import CheckboxMUI from "@mui/material/Checkbox";
import {
  Button,
  FormControlLabel,
  Paper,
  Switch,
  TextField,
} from "@mui/material";

interface CheckboxProps {
    label: string;
    value: boolean;
    onChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
    name: string;
}

export const Checkbox: React.FC<CheckboxProps> = ({ label, value, onChange, name}) => {
    return (
      <FormControlLabel
            label ={label}
            control={
        <CheckboxMUI checked={value} onChange={onChange} name={name} />
        }
      />
    );
  };