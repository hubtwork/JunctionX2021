/* eslint-disable react/jsx-props-no-spreading */
import React, { useState } from 'react';
import styled from 'styled-components';
import { useHistory } from 'react-router-dom';
import { useInput } from '../hooks/useInput';
import { InputWithLabel } from '../components/Auth';

const Container = styled.div`
  display: flex;
  flex-direction: column;
  margin: auto;
  width: 600px;
`;

const Title = styled.span`
  font-size: 3rem;
  color: #454545;
  margin-bottom: 50px;
`;

const WorkspaceForm = styled.form``;

const ButtonContainer = styled.div`
  display: flex;
  width: 100%;
  justify-content: space-around;
`;

const CreateButton = styled.button`
  width: 167px;
  height: 54px;
  background-color: #7ffa91;
  font-size: 2rem;
  margin-top: 3rem;
  margin-bottom: 2rem;
  line-height: 4rem;
  border-radius: 10rem;
  text-align: center;
  font-weight: bold;
  cursor: pointer;
  color: #454545;
`;

const CancelButton = styled.button`
  width: 167px;
  height: 54px;
  background-color: #454545;
  font-size: 2rem;
  margin-top: 3rem;
  margin-bottom: 2rem;
  line-height: 4rem;
  border-radius: 10rem;
  text-align: center;
  font-weight: bold;
  cursor: pointer;
  color: white;
`;

function Workspace() {
  const {
    value: projectname,
    bind: bindProjecttName,
    reset: resetProjectName,
  } = useInput('');
  const {
    value: manager,
    bind: bindManager,
    reset: resetManager,
  } = useInput('');

  const [disabled, setDisabled] = useState(false);
  const history = useHistory();

  const createProject = async userInfo => {
    setDisabled(true);

    try {
      alert('Project Create Success!!');
      history.push('/main');
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
    createProject({ projectname, manager });

    alert(`Submitting Name ${projectname}`);

    resetProjectName();
    resetManager();
    setDisabled(false);
  };
  return (
    <Container>
      <Title>New Project</Title>
      <WorkspaceForm onSubmit={handleSubmit}>
        <InputWithLabel
          label="Project name"
          name="projectname"
          placeholder="Project name"
          {...bindProjecttName}
        />
        <InputWithLabel
          label="Manager"
          name="manager"
          placeholder="Manager"
          {...bindManager}
          style={{ marginBottom: '10px' }}
        />
        <span style={{ fontSize: '15px', color: 'red' }}>
          * The person who created the project becomes the general manager
        </span>
        <InputWithLabel
          label="Manager"
          name="manager"
          placeholder="Manager"
          {...bindManager}
          style={{ marginBottom: '10px' }}
        />
        <InputWithLabel
          label="Manager"
          name="manager"
          placeholder="Manager"
          {...bindManager}
          style={{ marginBottom: '10px' }}
        />
        <InputWithLabel
          label="Manager"
          name="manager"
          placeholder="Manager"
          {...bindManager}
          style={{ marginBottom: '10px' }}
        />
        <ButtonContainer>
          <CreateButton type="submit" value="submit" disabled={disabled}>
            Create
          </CreateButton>
          <CancelButton type="submit" value="submit" disabled={disabled}>
            Cancel
          </CancelButton>
        </ButtonContainer>
      </WorkspaceForm>
    </Container>
  );
}

export default Workspace;
