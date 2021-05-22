/* eslint-disable react/jsx-props-no-spreading */
import React, { useState } from 'react';
import styled from 'styled-components';
import axios from 'axios';
import { userApi } from './api';
import { AuthContent, AuthWrapper, InputWithLabel } from './components/Auth';

import logo from './assets/logo.png';
import { useInput } from './hooks/useInput';

const Container = styled.div`
  width: 100%;
  height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

const LogoContainer = styled.div`
  width: 100%;
  text-align: center;
`;

const LogoImage = styled.img`
  width: 50%;
  margin-bottom: 4rem;
`;

const LoginButton = styled.button`
  width: 100%;
  background-color: #7ffa91;
  font-size: 2rem;
  margin-top: 3rem;
  margin-bottom: 2rem;
  line-height: 4rem;
  border-radius: 10rem;
  text-align: center;
  font-weight: bold;
  cursor: pointer;
`;

const UserUtilContainer = styled.div`
  display: flex;
  flex-direction: column;
`;

const UtilText = styled.span`
  margin-bottom: 1rem;
`;

const LoginForm = styled.form``;

function App() {
  const {
    value: username,
    bind: bindUsertName,
    reset: resetUserName,
  } = useInput('');
  const {
    value: password,
    bind: bindPassword,
    reset: resetPassword,
  } = useInput('');

  const [disabled, setDisabled] = useState(false);

  const loginUser = async userInfo => {
    setDisabled(true);

    try {
      const { data } = await userApi.login(userInfo);

      axios.defaults.headers.common.Authorization = `Bearer ${data.token}`;

      console.log(data);
    } catch (error) {
      console.log(error);
    } finally {
      setDisabled(false);
    }
  };

  const handleSubmit = event => {
    console.log('hello');
    setDisabled(true);
    event.preventDefault();
    loginUser({ username, password });

    alert(`Submitting Name ${username}`);

    resetUserName();
    resetPassword();
    setDisabled(false);
  };

  return (
    <Container>
      <AuthWrapper>
        <AuthContent>
          <LogoContainer>
            <LogoImage src={logo} alt="logo" />
          </LogoContainer>
          <LoginForm onSubmit={handleSubmit}>
            <InputWithLabel
              label="EMAIL"
              name="username"
              placeholder="EMAIL"
              {...bindUsertName}
            />
            <InputWithLabel
              label="PASSWORD"
              name="password"
              placeholder="PASSWORD"
              type="password"
              {...bindPassword}
            />
            <LoginButton type="submit" value="submit" disabled={disabled}>
              Login
            </LoginButton>
          </LoginForm>
          <UserUtilContainer>
            <UtilText>Forgot your password?</UtilText>
            <UtilText>Forgot your password?</UtilText>
          </UserUtilContainer>
        </AuthContent>
      </AuthWrapper>
    </Container>
  );
}

export default App;
