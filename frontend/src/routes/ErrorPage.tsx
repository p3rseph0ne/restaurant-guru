import { useNavigate } from "react-router-dom";
import "../App.css";
import { useEffect } from "react";

export default function ErrorPage() {
  const navigate = useNavigate();

  useEffect(() => {
    navigate('/')
  }, [])

  return (
    <div id="error-page">
    </div>
  );
}