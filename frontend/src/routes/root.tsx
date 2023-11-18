import { Button } from "@mui/material";
import { useNavigate } from "react-router";

export default function Root() {
  const navigate = useNavigate();

  return (
        <div className="form">
          <div className="flex-container"></div>
          <h3>Wachu wanna do sweetcheeks?</h3>
          <div>
            <Button variant="text" onClick={() => navigate('/person')}>I really really really wanna create a Person!</Button>
          </div>
          <div>
            <Button variant="text" onClick={() => navigate('/restaurant')}> 
                    Nah man tell me what I should eat
            </Button>
          </div>
          <div>
            <Button variant="text" onClick={() => navigate('/Delete-Person')}> 
                    It's too crowded here, let me throw someone out
            </Button>
          </div>
        </div>
  );
}
