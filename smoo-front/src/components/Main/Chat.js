import React from 'react';
import styled from 'styled-components';
import SendIcon from '../../assets/SendBtn.svg';
import EmoticonIcon from '../../assets/EmoticonIcon.svg';
import UploadBtn from '../../assets/UploadBtn.svg';
import defaultProfile from '../../assets/default-profile.svg';

const Container = styled.div`
  width: 100%;
  height: calc(100vh - 30rem);
  overflow-y: scroll;
  display: flex;
  flex-direction: column;
  -ms-overflow-style: none; /* IE and Edge */
  scrollbar-width: none; /* Firefox */
  ::-webkit-scrollbar {
    display: none; /* Chrome, Safari, Opera*/
  }
`;

const ChatRoomContainer = styled.div`
  height: calc(100%-55px);
  flex: 1;
`;
const UserMakeContainer = styled.div`
  margin: 0 20px;
`;
const LeftChatContainer = styled.div`
  width: 100%;
  display: flex;
  margin-bottom: 10px;
`;
const RightChatContainer = styled.div`
  width: 100%;
  display: flex;
  justify-content: flex-end;
  margin-bottom: 10px;
  text-align: right;
`;

const Profile = styled.img``;

const ChatUserName = styled.span`
  font-size: 2.3rem;
`;

const ChatTextContainer = styled.div`
  border-radius: 27px;
  background-color: ${props =>
    props.self ? '#7ffa91' : 'rgba(69, 69, 69, 0.05)'};
  padding: 2rem;
`;

const ChatText = styled.span`
  font-size: 2.2rem;
`;

const NotReadUsers = styled.span`
  color: '#20d33b';
  font-size: 1.6rem;
  vertical-align: bottom;
`;

const SendTime = styled.span`
  color: #454545;
  font-size: 1.5rem;
`;

const NumberContainer = styled.div`
  justify-content: flex-end;
  display: flex;
  flex-direction: column;
  align-items: flex-end;
`;

const LineContainer = styled.div``;

const Date = styled.span``;

const TypingContainer = styled.div`
  flex: 1;
  display: flex;
  position: absolute;
  bottom: 0;
  height: 55px;
  width: 70%;
  margin-bottom: 10px;
`;

const Typing = styled.input`
  margin: 0px 10px;
  flex: 1;
  background-color: rgba(69, 69, 69, 0.05);
  border-radius: 27px;
  padding: 20px;
  font-size: 20px;
`;

const AddBtn = styled.img``;

const Emoticon = styled.img``;

const SendBtn = styled.img``;

function Chat() {
  return (
    <Container>
      <ChatRoomContainer>
        <LeftChatContainer>
          <Profile src={defaultProfile} alt="" />
          <UserMakeContainer>
            <ChatUserName>SeongJin</ChatUserName>
            <ChatTextContainer>
              <ChatText>I got a complaint from custom</ChatText>
            </ChatTextContainer>
          </UserMakeContainer>
          <NumberContainer>
            <NotReadUsers>3</NotReadUsers>
            <SendTime>13:20</SendTime>
          </NumberContainer>
        </LeftChatContainer>
        <RightChatContainer>
          <NumberContainer>
            <NotReadUsers>3</NotReadUsers>
            <SendTime>13:20</SendTime>
          </NumberContainer>
          <UserMakeContainer>
            <ChatUserName>SeongJin</ChatUserName>
            <ChatTextContainer self>
              <ChatText>I got a complaint from custom</ChatText>
            </ChatTextContainer>
          </UserMakeContainer>
          <Profile src={defaultProfile} alt="" />
        </RightChatContainer>
      </ChatRoomContainer>
      <TypingContainer>
        <AddBtn src={UploadBtn} alt="upload" />
        <Typing>{/* <Emoticon src={EmoticonIcon} alt="emoticon" /> */}</Typing>
        <SendBtn src={SendIcon} alt="send" />
      </TypingContainer>
    </Container>
  );
}

export default Chat;
