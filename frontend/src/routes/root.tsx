import Header from "../components/Header";
import { Button, FormControlLabel, TextField, Link } from "@mui/material";
import CheckboxMUI from "@mui/material/Checkbox";

export default function Root() {
  return (
    <div className="pagecontainer">
      <Header />
      <div className="formcontainer">
        <div className="form">
          <div className="flex-container"></div>
          <h3>Wachu wanna do sweetcheaks?</h3>
          <div>
            <Link href="/person">I really really really wanna create a Person!</Link>
          </div>
          <div>
            <Link href="/restaurant">
              Nah man tell me what I should eat
            </Link>
          </div>
        </div>
      </div>
    </div>
  );
}
