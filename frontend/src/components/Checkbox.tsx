import React from "react"

interface CheckboxProps {
    label: string;
    value: boolean;
    onChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
    name: string;
}

export const Checkbox: React.FC<CheckboxProps> = ({ label, value, onChange, name}) => {
    return (
      <label>
        <input type="checkbox" checked={value} onChange={onChange} name={name} />
        {label}
      </label>
    );
  };