import React from 'react';
import { BrowserRouter, Route, Switch, Redirect } from 'react-router-dom';
import { Login, Workspace, Channel, Main } from './index';

const Router = () => (
  <BrowserRouter>
    <Switch>
      <Route path="/main/workspace" component={Main} />
      <Route path="/main/channel" component={Main} />
      <Route path="/main" component={Main} />
      <Route path="/" exact component={Login} />

      <Redirect from="*" to="/main" />
    </Switch>
  </BrowserRouter>
);

export default Router;
