// This file is shared across the demos.

import React from 'react';
import { ListItem, ListItemText, ListItemIcon } from '@material-ui/core';
import MicIcon from '@material-ui/icons/Mic';
import styled from 'styled-components';

const CustomListItemText = styled(ListItemText)`
  color: 'white';
`;
const mailFolderListItems = (
  <div>
    {/* <ListItem button>
      <ListItemIcon>
        <MicIcon />
      </ListItemIcon>
      <CustomListItemText primary="Inbox" />
    </ListItem>
    <ListItem button>
      <ListItemText primary="Starred" />
    </ListItem>
    <ListItem button>
      <ListItemText primary="Send mail" />
    </ListItem>
    <ListItem button>
      <ListItemText primary="Drafts" />
    </ListItem> */}
  </div>
);

export default mailFolderListItems;
