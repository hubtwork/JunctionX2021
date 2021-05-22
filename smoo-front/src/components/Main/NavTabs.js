/* eslint-disable react/jsx-props-no-spreading */
import React, { useState } from 'react';
import styled from 'styled-components';

const AppBarContainer = styled.div`
  display: flex;
  flex-direction: column;
  flex-grow: 1;
  background-color: '#F8F8F8';
`;

const AppBar = styled.div`
  display: flex;
  background-color: '#454545';
  color: 'white';
  height: '7rem';
  position: 'static';
`;

const Tabs = styled.div``;

const Tab = styled.div`
  height: '7rem';
`;

function a11yProps(index) {
  return {
    id: `nav-tab-${index}`,
    'aria-controls': `nav-tabpanel-${index}`,
  };
}

function LinkTab(props) {
  return (
    <Tab
      onClick={event => {
        event.preventDefault();
      }}
      {...props}
    />
  );
}
function NavTabs() {
  const [value, setValue] = useState(0);

  const handleChange = (event, newValue) => {
    console.log(newValue);
    setValue(newValue);
  };
  return (
    <AppBarContainer>
      <AppBar>
        <Tabs value={value} onChange={handleChange} aria-label="nav tabs">
          <LinkTab {...a11yProps(0)}>Page One</LinkTab>
          <LinkTab {...a11yProps(2)}>Page Two</LinkTab>
          <LinkTab {...a11yProps(2)}>Page Three</LinkTab>
          <LinkTab {...a11yProps(3)}>Page Four</LinkTab>
        </Tabs>
      </AppBar>
    </AppBarContainer>
  );
}

export default NavTabs;
