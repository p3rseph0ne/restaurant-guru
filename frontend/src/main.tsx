import * as React from "react";
import * as ReactDOM from "react-dom/client";
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import './index.css'
import Person from './routes/App_Person.tsx'
import Root from "./routes/root.tsx";
import ErrorPage from "./routes/error-page.tsx";
import Restaurant from './routes/App_Restaurant.tsx'

const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
    errorElement: <ErrorPage />,
  },
  {
    path: "/person",
    element: <Person />
  },
  {
    path: "/restaurant",
    element: <Restaurant />
  },
]);

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
