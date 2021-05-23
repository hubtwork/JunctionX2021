import express, { Request, Response, NextFunction } from 'express';
import * as bodyParser from 'body-parser'


import morgan = require('morgan')
import router from './routes/route';

class APP {
  
    public app: express.Application
  
    constructor() {
      this.app = express()
      this.initModules()
      this.initRouters()
      this.initErrorHandlers()
    }
  
    public serverOn() {
      this.app.listen(3030, () => {
        console.log(`server running on port : ${3030}`);
      }).on('error', (e) => console.error(e.message))
    }
  
    private initModules() {
      this.app.use(morgan('dev'))
      this.app.use(bodyParser.json({ limit: '10mb' }))
      this.app.use(bodyParser.urlencoded({ limit: '10mb', extended: true, parameterLimit: 50000 }))
  
      this.app.use(function (req, res, next) {
  
        // Website you wish to allow to connect
        res.setHeader('Access-Control-Allow-Origin', 'http://localhost:3000');
      
        // Request methods you wish to allow
        res.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE');
      
        // Request headers you wish to allow
        res.setHeader('Access-Control-Allow-Headers', 'X-Requested-With,content-type');
      
        // Set to true if you need the website to include cookies in the requests sent
        // to the API (e.g. in case you use sessions)
        res.setHeader('Access-Control-Allow-Credentials', 'true');
      
        // Pass to next layer of middleware
        next();
      })
    }
  
    private initErrorHandlers() {
      this.app.use((req, res, next) => {
        res.status(404).json({
          error: 'Not Found'
        })
      })
  
      this.app.use((err: Error, req: Request, res: Response, next: NextFunction) => {
        return res.status(500).send('Internal Error')
      })
    }
  
    public initRouters() {
      this.app.use('/', router)
    }
  
  }
  
  export default APP