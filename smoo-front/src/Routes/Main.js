import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import { List, Menu, MenuItem, Button } from '@material-ui/core';
import mailFolderListItems from '../components/Main/channelData';
import TabPanel from '../components/Main/TabPanel';
import NavTabs from '../components/Main/NavTabs';

const Container = styled.div`
  width: 100%;
  display: flex;
`;

const SideBar = styled.div`
  width: 350px;
  min-width: 300px;
  height: 100vh;
  background-color: #454545;
`;

const SideBarTitleContainer = styled.div`
  height: 7rem;
  text-align: center;
  align-items: center;
`;

const SideBarTitle = styled.span`
  display: block;
  font-size: 2.5rem;
  color: #7ffa91;
  line-height: 7rem;
  font-weight: bold;
`;

function Main() {
  const [title, setTitle] = useState('Project');
  const [anchorEl, setAnchorEl] = React.useState(null);

  const handleClick = event => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  return (
    <Container>
      <SideBar>
        <SideBarTitleContainer>
          <SideBarTitle>{title}</SideBarTitle>
        </SideBarTitleContainer>
        <List>{mailFolderListItems}</List>
      </SideBar>
      <TabPanel />
      {/* <NavTabs /> */}
    </Container>
  );
}

export default Main;
