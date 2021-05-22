/* eslint-disable react/jsx-props-no-spreading */
import React, { useState, useEffect } from 'react';
import styledComponent from 'styled-components';
import { Menu, MenuItem, Button } from '@material-ui/core';
import { styled, withStyles, StylesProvider } from '@material-ui/core/styles';
import ChannelListItems from '../components/Main/ChannelListItems';
import TabPanel from '../components/Main/TabPanel';
// import NavTabs from '../components/Main/NavTabs';

const Container = styledComponent.div`
  width: 100%;
  display: flex;
`;

const SideBar = styledComponent.div`
  width: 100%;
  max-width: 400px;
  height: 100vh;
  background-color: #454545;
  text-align: center;
`;

const CustomButton = styled(Button)({
  width: '100%',
  minWidth: '400px',
  height: '7rem',
  fontSize: '2.5rem',
  fontWeight: 'bold',
  color: '#7ffa91',
  position: 'relative',
  wordBreak: 'keep-all',
  margin: '0',
});

const StyledMenu = withStyles({
  paper: {
    border: '1px solid #d3d4d5',
    width: '100%',
    maxWidth: '250px',
  },
})(props => (
  <Menu
    elevation={0}
    getContentAnchorEl={null}
    anchorOrigin={{
      vertical: 'bottom',
      horizontal: 'center',
    }}
    transformOrigin={{
      vertical: 'top',
      horizontal: 'center',
    }}
    {...props}
  />
));

const SideBarTitleContainer = styledComponent.div`
  height: 7rem;
  text-align: center;
  align-items: center;
`;

const SideBarTitle = styledComponent.span`
  display: block;
  font-size: 2.5rem;
  color: #7ffa91;
  line-height: 7rem;
  font-weight: bold;
`;

function Main() {
  const [title, setTitle] = useState('2021 MS Conference');
  const [anchorEl, setAnchorEl] = React.useState(null);
  const [headerText, setHeaderText] = useState('');

  const handleClick = event => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  const changeHeader = text => {
    setHeaderText(text);
  };

  return (
    <Container>
      <SideBar>
        <CustomButton
          aria-controls="simple-menu"
          aria-haspopup="true"
          onClick={handleClick}
        >
          {title}
        </CustomButton>
        <StyledMenu
          id="simple-menu"
          anchorEl={anchorEl}
          keepMounted
          open={Boolean(anchorEl)}
          onClose={handleClose}
        >
          <MenuItem onClick={handleClose}>Profile</MenuItem>
          <MenuItem onClick={handleClose}>My account</MenuItem>
          <MenuItem onClick={handleClose}>Logout</MenuItem>
        </StyledMenu>
        {/* <SideBarTitleContainer>
          <SideBarTitle>{title}</SideBarTitle>
        </SideBarTitleContainer> */}
        <ChannelListItems changeHeader={changeHeader} />
      </SideBar>
      <TabPanel headerText={headerText} />
    </Container>
  );
}

export default Main;
