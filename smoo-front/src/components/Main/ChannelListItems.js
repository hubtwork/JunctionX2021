// This file is shared across the demos.

import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import DetailsIcon from '@material-ui/icons/Details';
import ChangeHistoryIcon from '@material-ui/icons/ChangeHistory';
import PropTypes from 'prop-types';

const ChannelContainer = styled.div`
  display: flex;
  flex-direction: column;
  padding: 3rem;
  padding-right: 5rem;
`;

const FolderContainer = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  cursor: pointer;
  margin-bottom: 3rem;
`;

const Folder = styled.span`
  font-size: 2rem;
  font-weight: bold;
  color: #7ffa91;
`;

const ChannelListContainer = styled.nav`
  background-color: #454545;
  display: flex;
  transition: height 0.5s linear;
  height: ${props => (props.open ? '100%' : 0)};
`;

const ChannelList = styled.ul`
  display: flex;
  flex-direction: column;
  height: ${props => (props.open ? '100%' : 0)};
  transition: height 0.5s linear;
`;

const ChannelItem = styled.li`
  margin-bottom: 2rem;
  font-size: 2rem;
  opacity: ${props => (props.open ? 1 : 0)};
  transform: ${props =>
    props.open ? 'translateY(20px)' : 'translatyeY(-20px)'};
  transition: transform 0.6s linear, opacity 0.6s linear;
`;

const ChannelLink = styled.a`
  position: relative;
  color: #000;
  text-decoration: none;
  color: #fff;
  margin: 1rem 0;
`;

function ChannelListItems({ changeHeader }) {
  const [isOpen, setIsOpen] = useState(true);

  const dummyData = ['1', '2', '3'];
  useEffect(() => {
    console.log('click!!@');
  }, [isOpen]);

  const handleClick = () => {
    console.log('click');
    setIsOpen(!isOpen);
  };

  const changeChannel = idx => {
    console.log(idx);
    changeHeader('change');
  };

  return (
    <ChannelContainer>
      <FolderContainer onClick={handleClick}>
        <Folder> hello </Folder>
        {/* {isOpen ? (
          <DetailsIcon color="#7ffa91" />
        ) : (
          <>
            <DetailsIcon
              // styld={{
              //   transform: 'rotate(180deg)',
              //   transition: 'transform 150ms ease',
              // }}
              color="#7ffa91"
            />
          </>
        )} */}
      </FolderContainer>
      <ChannelListContainer open={isOpen}>
        <ChannelList open={isOpen}>
          <ChannelItem open={isOpen}>
            <ChannelLink>Hello</ChannelLink>
          </ChannelItem>
          <ChannelItem open={isOpen}>
            <ChannelLink onClick={changeChannel}>Hello</ChannelLink>
          </ChannelItem>
          <ChannelItem open={isOpen}>
            <ChannelLink>Hello</ChannelLink>
          </ChannelItem>
          <ChannelItem open={isOpen}>
            <ChannelLink>Hello</ChannelLink>
          </ChannelItem>
          <ChannelItem open={isOpen}>
            <ChannelLink>Hello</ChannelLink>
          </ChannelItem>
          <ChannelItem open={isOpen}>
            <ChannelLink>Hello</ChannelLink>
          </ChannelItem>
          <ChannelItem open={isOpen}>
            <ChannelLink>Hello</ChannelLink>
          </ChannelItem>
          <ChannelItem open={isOpen}>
            <ChannelLink>Hello</ChannelLink>
          </ChannelItem>
          <ChannelItem open={isOpen}>
            <ChannelLink>Hello</ChannelLink>
          </ChannelItem>
        </ChannelList>
      </ChannelListContainer>
    </ChannelContainer>
  );
}

ChannelListItems.propTypes = {
  changeHeader: PropTypes.func.isRequired,
};

export default ChannelListItems;
