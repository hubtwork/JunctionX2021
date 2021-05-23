/* eslint-disable react/jsx-props-no-spreading */
import React, { useState } from 'react';
import { styled, makeStyles } from '@material-ui/core/styles';
import PropTypes from 'prop-types';
import styledComponent from 'styled-components';
import AppBar from '@material-ui/core/AppBar';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import Voice from './Voice';
import Chat from './Chat';
import Drive from './Drive';

import logo from '../../assets/logo.png';

const CustomAppBar = styled(AppBar)({
  background: '#454545',
  height: '7rem',
});

const CustomTab = styled(Tab)({
  height: '7rem',
  borderLeft: '1px solid white',
  '&:last-child': { borderRight: '1px solid white' },
  fontSize: '1.4rem',
  fontWeight: 'bold',
});

const InitialPanel = styledComponent.div`
  width: 100%;
  height: calc(100% - 7rem);
  display: flex;
  justify-content: center;
  align-items: center;
  vertical-align: middle;
`;

const LogoImage = styledComponent.img`
  width: 50%;
  vertical-align: middle;
`;

const Header = styledComponent.div`
  display: flex;
  align-items: center;
  width: 100%;
  height: 7.2rem;
  padding-left: 4.6rem;
  border-bottom: 1px solid #939393;
  color: #454545;
  font-size: 24px;
  visibility: ${props =>
    props.value !== 4 || props.value !== 0 ? 'visible' : 'none'}
`;

const InsideContainer = styledComponent.div`
    width: 100%;
    height: calc(100% - 14rem);
`;

function TabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`nav-tabpanel-${index}`}
      aria-labelledby={`nav-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box p={5}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

TabPanel.propTypes = {
  children: PropTypes.node.isRequired,
  index: PropTypes.number.isRequired,
  value: PropTypes.string.isRequired,
};

function a11yProps(index, value) {
  return {
    id: `nav-tab-${index}`,
    'aria-controls': `nav-tabpanel-${index}`,
    style:
      index === value ? { color: '#7FFA91' } : { color: 'white', opacity: 1 },
  };
}

function LinkTab(props) {
  return (
    <CustomTab
      // component="a"
      onClick={event => {
        event.preventDefault();
      }}
      {...props}
    />
  );
}

const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1,
    backgroundColor: '#F8F8F8',
  },
  indicator: {
    backgroundColor: '#7FFA91',
  },
  hiddenIndicator: {
    backgroundColor: '#454545',
  },
}));

export default function NavTabs({ headerText }) {
  const classes = useStyles();
  const [value, setValue] = useState(0);

  const handleChange = (event, newValue) => {
    if (headerText === '') alert('채널을 선택해주세요');
    else setValue(newValue);
  };

  console.log(`headerText: ${headerText}`);
  return (
    <div className={classes.root}>
      <CustomAppBar position="static">
        <Tabs
          value={value}
          onChange={handleChange}
          aria-label="nav tabs"
          classes={{
            indicator:
              value !== 0 ? classes.indicator : classes.hiddenIndicator,
          }}
        >
          <LinkTab
            label="Page Hidden"
            href="/drafts"
            {...a11yProps(0, value)}
            style={{ display: 'none' }}
          />
          <LinkTab label="Voice" {...a11yProps(1, value)} />
          <LinkTab label="Chat" {...a11yProps(2, value)} />
          <LinkTab label="Drive" {...a11yProps(3, value)} />
          <LinkTab label="Map" {...a11yProps(4, value)} />
        </Tabs>
      </CustomAppBar>
      {value === 0 ? (
        <InitialPanel>
          <LogoImage src={logo} alt="logo" />{' '}
        </InitialPanel>
      ) : (
        <>
          <Header value={value}>{headerText}</Header>
          <InsideContainer>
            <TabPanel style={{ display: 'none' }} value={value} index={0}>
              Page Hidden
            </TabPanel>
            <TabPanel value={value} index={1}>
              <Voice />
            </TabPanel>
            <TabPanel value={value} index={2}>
              <Chat />
            </TabPanel>
            <TabPanel value={value} index={3}>
              <Drive />
            </TabPanel>
            <TabPanel value={value} index={4}>
              Map
            </TabPanel>
          </InsideContainer>
        </>
      )}
    </div>
  );
}

NavTabs.propTypes = {
  headerText: PropTypes.string,
};

NavTabs.defaultProps = {
  headerText: '',
};
