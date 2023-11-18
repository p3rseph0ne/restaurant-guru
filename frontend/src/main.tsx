import * as React from "react";
import * as ReactDOM from "react-dom/client";
import {createBrowserRouter, RouterProvider,} from "react-router-dom";
import './index.css'
import Person from './routes/Person.tsx'
import Root from "./routes/root.tsx";
import ErrorPage from "./routes/ErrorPage.tsx";
import Restaurant from './routes/Restaurant.tsx';
import DeletePerson from './routes/DeletePerson.tsx';
import Page from "./routes/Page.tsx";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Page />,
    errorElement: <ErrorPage />,
    children: [
      {
        path: "/",
        index: true,
        element: <Root />
      },
      {
        path: "/person",
        element: <Person />
      },
      {
        path: "/restaurant",
        element: <Restaurant />
      },
      {
        path: "/delete-Person",
        element: <DeletePerson />
      }
    ]
  },

]);

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
