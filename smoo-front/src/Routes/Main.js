/* eslint-disable react/jsx-props-no-spreading */
import React, { useState, useEffect } from 'react';
import styledComponent from 'styled-components';
import { Menu, MenuItem, Button } from '@material-ui/core';
import { useLocation, useParams, useHistory } from 'react-router-dom';
import { styled, withStyles, StylesProvider } from '@material-ui/core/styles';
import ChannelListItems from '../components/Main/ChannelListItems';
import TabPanel from '../components/Main/TabPanel';
// import NavTabs from '../components/Main/NavTabs';
import AddIcon from '../assets/UploadBtn.svg';
import Workspace from './Workspace';
import Channel from './Channel';

const Container = styledComponent.div`
  width: 100%;
  display: flex;
  position: relative;
`;

const SideBar = styledComponent.div`
  width: 100%;
  max-width: 320px;
  height: 100%;
  min-height: 100vh;
  background-color: #454545;
  text-align: center;
  z-index: 1;
`;

const CustomButton = styled(Button)({
  width: '320px',
  height: '7rem',
  fontSize: '2.5rem',
  fontWeight: 'bold',
  color: '#7ffa91',
  wordBreak: 'keep-all',
  margin: '0',
  padding: '0',
});

const AddButton = styledComponent.img`
  width: 15px;
  height: 15px;
`;

const StyledMenu = withStyles({
  paper: {
    border: '1px solid #d3d4d5',
    width: '100%',
    maxWidth: '250px',
    textAlign: 'center',
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
  const history = useHistory();
  const location = useLocation();
  const [groups, setGroups] = useState();
  const [channelDatas, setChannelDatas] = useState();
  useEffect(() => {
    if (location.state === undefined) history.push('/');
    const { data } = location.state;
    try {
      const { groupResponseList } = data;
      setGroups(groupResponseList);
      console.log(`groupData: ${JSON.stringify(groupResponseList[0])}`);
      const { channelResponseList } = groupResponseList[0];
      setChannelDatas(channelResponseList);
    } catch {
      history.push('/');
    }
  }, []);
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

  console.log(location);

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
          {groups &&
            groups.map(group => {
              console.log(`group: ${group}`);
              return (
                <MenuItem key={group.groupId} onClick={handleClose}>
                  {group.name}
                </MenuItem>
              );
            })}

          <MenuItem onClick={() => history.push('/main/workspace')}>
            <AddButton src={AddIcon} alt="add" />
          </MenuItem>
        </StyledMenu>
        {/* <SideBarTitleContainer>
          <SideBarTitle>{title}</SideBarTitle>
        </SideBarTitleContainer> */}
        <ChannelListItems
          channelDatas={channelDatas}
          changeHeader={changeHeader}
        />
      </SideBar>
      {location.pathname === '/main' && <TabPanel headerText={headerText} />}

      {location.pathname === '/main/workspace' && <Workspace />}
      {location.pathname === '/main/channel' && <Channel />}
    </Container>
  );
}

export default Main;
