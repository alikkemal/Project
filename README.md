# n11 Docker'ı localinizde kurduktan sonra terminal üzerinde aşağıdaki adımları uygulayın:
 # Pull docker-selenium
  docker pull elgalu/selenium

  # Pull Zalenium
  docker pull dosel/zalenium
        
  docker run --rm -ti --name zalenium -p 4444:4444 \
    -v /var/run/docker.sock:/var/run/docker.sock \
    -v /tmp/videos:/home/seluser/videos \
    --privileged dosel/zalenium start
    
    
#src/test/java altında oluşturmuş olduğumuz Root Direktory içerisinde kullanılacak driver remote olarak url ile birlikte tanımlanır. Koşulan testler Zalenium Dashboard (Örn:http://192.19.21.9:4444/dashboard/#) üzerinden takip edilir.
