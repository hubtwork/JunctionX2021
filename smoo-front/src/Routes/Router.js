import React from 'react';
import { BrowserRouter, Route, Switch, Redirect } from 'react-router-dom';
import { Login, Workspace, Channel, Main } from './index';

const Router = () => (
  <BrowserRouter>
    <Switch>
      <Route path="/workspace" component={Workspace} />
      <Route path="/channel" component={Channel} />
      <Route path="/main" component={Main} />
      <Route path="/" exact component={Login} />

      <Redirect from="*" to="/main" />
    </Switch>
  </BrowserRouter>
);

export default Router;
