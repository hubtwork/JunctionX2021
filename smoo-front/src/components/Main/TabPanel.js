/* eslint-disable react/jsx-props-no-spreading */
import React from 'react';
import { styled, makeStyles, StylesProvider } from '@material-ui/core/styles';
import PropTypes from 'prop-types';
import styledComponent from 'styled-components';
import AppBar from '@material-ui/core/AppBar';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';

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
        <Box p={4}>
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
}));

export default function NavTabs() {
  const classes = useStyles();
  const [value, setValue] = React.useState(-1);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <div className={classes.root}>
      <CustomAppBar position="static">
        <Tabs
          value={value}
          onChange={handleChange}
          aria-label="nav tabs"
          classes={{
            indicator: classes.indicator,
          }}
        >
          <LinkTab label="Page One" href="/drafts" {...a11yProps(0, value)} />
          <LinkTab label="Page Two" href="/trash" {...a11yProps(1, value)} />
          <LinkTab label="Page Three" href="/spam" {...a11yProps(2, value)} />
          <LinkTab label="Page Four" href="/spam" {...a11yProps(3, value)} />
        </Tabs>
      </CustomAppBar>
      {value === -1 ? (
        <InitialPanel>
          <LogoImage src={logo} alt="logo" />{' '}
        </InitialPanel>
      ) : (
        <>
          <TabPanel value={value} index={0}>
            Page One
          </TabPanel>
          <TabPanel value={value} index={1}>
            Page Two
          </TabPanel>
          <TabPanel value={value} index={2}>
            Page Three
          </TabPanel>
          <TabPanel value={value} index={3}>
            Page Four
          </TabPanel>
        </>
      )}
    </div>
  );
}
