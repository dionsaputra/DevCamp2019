from django.db import models
from django.utils import timezone

# Create your models here.
class Order(models.Model):
    order_id = models.CharField(max_length=100)
    date_time = models.DateTimeField(default=timezone.now)
    customer_name = models.CharField(max_length=100)
    customer_address = models.CharField(max_length=100)
    customer_phone = models.CharField(max_length=100)
