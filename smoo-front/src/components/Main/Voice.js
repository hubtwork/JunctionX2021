import React from 'react';
import styled from 'styled-components';
import defaultProfile from '../../assets/default-profile.svg';

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-around;
  flex-wrap: wrap;
`;

const Card = styled.div`
  width: 45rem;
  height: 11rem;
  background-color: #454545;
  & + & {
    margin-top: 1.5rem;
  }
  display: flex;
  align-items: center;
  padding: 3.4rem;
  border-radius: 20px;
`;

const UserInfo = styled.div`
  display: flex;
  flex-direction: column;
  flex: 1;
  justify-content: space-around;
`;

const Status = styled.div`
  width: 13px;
  height: 13px;
  border: none;
  background-color: ${props => props.status || '#d5d5d5'};
  border-radius: 100%;
  margin-bottom: 1rem;
`;
const Name = styled.span`
  color: #feffff;
  font-size: 1.8rem;
  line-height: 2.5rem;
`;
const Position = styled.span`
  color: #feffff;
  font-size: 1.8rem;
  line-height: 2.5rem;
`;

const Profile = styled.img`
  width: 73px;
  height: 73px;
`;

function Voice() {
  return (
    <Container>
      <Card>
        <UserInfo>
          <Status />
          <Name>
            <strong>Name:</strong>
            <span>이름</span>
          </Name>
          <Position>
            <strong>Position:</strong>
            <span>이름</span>
          </Position>
        </UserInfo>
        <Profile src={defaultProfile} alt="" />
      </Card>
    </Container>
  );
}

export default Voice;
