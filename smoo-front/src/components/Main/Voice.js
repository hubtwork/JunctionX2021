import React from 'react';
import styled from 'styled-components';
import defaultProfile from '../../assets/default-profile.svg';

const Container = styled.div`
  display: flex;
  align-items: center;
  /* justify-content: center; */
  width: 100%;
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

const Bottom = styled.div`
  display: flex;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 140px;
  padding-left: 10px;

  /* margin-left: 50px; */
  align-items: center;
  position: absolute;
  justify-content: space-between;
  background-color: #eaeaea;
`;

const ReacordOustCircle = styled.div`
  border: 1px solid #707070;
  border-radius: 100%;
  z-index: 2;
  display: flex;
  width: 90px;
  height: 90px;
  position: absolute;
  background-color: transparent;
`;

const RecordButton = styled.div`
  /* width: 74px;
  height: 74px;
  background-color: '#ee3327';
  position: absolute; */
  border: 1px solid #707070;
  border-radius: 100%;
  z-index: 2;
  display: flex;
  width: 70px;
  height: 70px;
  position: relative;
  background-color: red;
`;

const EmergencyCall = styled.button`
  border-radius: 15px;
  background-color: #454545;
  height: 56px;
  width: 183px;
`;

const FakeEmergencyCall = styled.button`
  border-radius: 15px;
  background-color: #454545;
  height: 56px;
  width: 183px;
  visibility: hidden;
`;

const Circle = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;

function Voice() {
  console.log(window.scrollX);
  return (
    <>
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
      <Bottom>
        <EmergencyCall />
        <Circle>
          <ReacordOustCircle />
          <RecordButton />
        </Circle>
        <FakeEmergencyCall />
      </Bottom>
    </>
  );
}

export default Voice;
