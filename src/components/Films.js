import React, {Component} from 'react'
import Grid from '@material-ui/core/Grid';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import Typography from '@material-ui/core/Typography';
import Link from '@material-ui/core/Link';

class Films extends Component {
    render() {
        return(
            <div>
                <Grid item xs={12} md={6}>
                    <Typography variant="h6">
                    Text only
                    </Typography>
                    <div>
                        <List>
                            <ListItem>
                                <Link>Movie Name</Link>
                            </ListItem>
                        </List>
                    </div>
                </Grid>
            </div>
        )
    }
}

export default Films