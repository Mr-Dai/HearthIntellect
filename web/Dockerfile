FROM nginx
MAINTAINER Windy <chenchuowen@foxmail>


ADD ./nginx.conf /etc/nginx/conf.d/default.conf
ADD ./dist /www/hearthStone

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
